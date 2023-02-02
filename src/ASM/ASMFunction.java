package ASM;

import ASM.ASMIns.ASMCalc;
import ASM.ASMIns.ASMLi;
import ASM.ASMIns.ASMLw;
import ASM.ASMIns.ASMSw;
import ASM.ASMutility.ASMGlob;
import ASM.ASMutility.ASMImm;
import ASM.ASMutility.ASMStack;
import ASM.ASMutility.ASMVar;
import AST.ASNBinaryExpr;
import IR.IRBlock;
import IR.IRFunction;
import IR.IRIns.IRCalc;
import IR.IRIns.IRLoad;
import IR.IRIns.IRRet;
import IR.IRIns.IRStore;
import IR.IRUtility.IRVar;

import java.util.*;

import static ASM.ASMutility.ASMImm.base;
import static ASM.ASMutility.ASMVar.regName.*;


public class ASMFunction {
    public String funcName;
    public LinkedList<ASMBlock> blocks = new LinkedList<>();
    public Map<IRVar, ASMVar> varMapping = new LinkedHashMap<>();
    public int stackOffset = 0;
    ASMBlock curBlock;
    Random r = new Random();

    public List<ASMVar.regName> availableReg = List.of(t0, t1, t2, t3, t4, t5, t6, a0, a1, a2, a3, a4, a5, a6, a7);
    public LinkedHashMap<ASMVar.regName, ASMVar> regRenameTable = new LinkedHashMap<>();

    public void resetRename() {
        for (var avalReg : availableReg) {
            regRenameTable.put(avalReg, null);
        }
    }

    public void regApply(ASMVar var) {
        if (var.reg == null || !var.equals(regRenameTable.get(var.reg))) {
            int pos = r.nextInt() % availableReg.size();
            regRenameTable.put(availableReg.get(pos), var);
            var.reg = availableReg.get(pos);
            if (var instanceof ASMStack) {
                curBlock.addIns(new ASMLw(var.reg, sp, new ASMImm(((ASMStack) var).offset)));
            } else if (var instanceof ASMGlob) {
                curBlock.addIns(new ASMLw(var.reg, var));
            } else if (var instanceof ASMImm) {
                var loadIns = new ASMLi();
                loadIns.imm = var;
                loadIns.rd = var.reg;
                curBlock.addIns(loadIns);
            }
        }
    }

    public int lowTrans(int imm) {
        return (imm < base && imm >= -base) ? imm : (imm >> 12) + (imm & (base - 1));
    }

    public ASMVar getAsmVar(IRVar var) {
        if (varMapping.containsKey(var)) return varMapping.get(var);
        switch (var.genre) {
            case LITERAL -> {
                var curVar = new ASMImm(lowTrans(var.literal));
                varMapping.put(var, curVar);
                return curVar;
            }
            case GLOBAL -> {
                var curVar = new ASMGlob(var.name);
                varMapping.put(var, curVar);
                return curVar;
            }
            default -> {
                stackOffset += 4;
                var curVar = new ASMStack();
                curVar.offset = stackOffset;
                varMapping.put(var, curVar);
                return curVar;
            }
        }
    }


    public ASMFunction(IRFunction irFunc) {
        resetRename();
        funcName = irFunc.funcName;
        int blockCount = 0;
        var initBlock = new ASMBlock(blockCount, this);
        var insStackPtrMove = new ASMCalc("add", sp, sp, new ASMImm());
        initBlock.addIns(insStackPtrMove);
        for (int i = 0; i < irFunc.paras.size(); ++i) {
            var para = irFunc.paras.get(i);
            var asmPara = getAsmVar(para);
            if (i < 8) {
                asmPara.reg = availableReg.get(i + 7);
                regRenameTable.put(asmPara.reg, asmPara);
            }
        }
        blocks.add(initBlock);
        ++blockCount;
        for (var irBlock : irFunc.blocks) {
            blocks.add(blockBuild(irBlock, blockCount, this));
        }
    }

    public ASMBlock blockBuild(IRBlock irBlock, int index, ASMFunction srcFunc) {
        var curBlock = new ASMBlock(index, srcFunc);
        for (var irIns : irBlock.insList) {
            if (irIns instanceof IRCalc irCalc) {
                var rs1 = getAsmVar(irCalc.lhs);
                var rs2 = getAsmVar(irCalc.rhs);
                var rd = getAsmVar(irCalc.des);
                regApply(rs1);
                regApply(rs2);
                regApply(rd);
                switch (irCalc.op) {
                    case plus, minus, or, and, div, mod, leftShift, rightShift, exclusiveOr -> {
                        curBlock.addIns(new ASMCalc(irOptrans(irCalc.op), rd.reg, rs1.reg, rs2.reg));
                    }
                    case equal -> {
                        curBlock.addIns(new ASMCalc("xor", rd.reg, rs1.reg, rs2.reg));
                        curBlock.addIns(new ASMCalc("seqz", rd.reg, rd.reg));
                    }
                    case notEqual -> {
                        curBlock.addIns(new ASMCalc("xor", rd.reg, rs1.reg, rs2.reg));
                        curBlock.addIns(new ASMCalc("snez", rd.reg, rd.reg));
                    }
                    case greater -> {
                        curBlock.addIns(new ASMCalc("slt", rd.reg, rs2.reg, rs1.reg));
                    }
                    case greaterEqual -> {
                        curBlock.addIns(new ASMCalc("slt", rd.reg, rs1.reg, rs2.reg));
                        curBlock.addIns(new ASMCalc("xor", rd.reg, rd.reg, new ASMImm(1)));
                    }
                    case less -> {
                        curBlock.addIns(new ASMCalc("slt", rd.reg, rs1.reg, rs2.reg));
                    }
                    case lessEqual -> {
                        curBlock.addIns(new ASMCalc("slt", rd.reg, rs2.reg, rs1.reg));
                        curBlock.addIns(new ASMCalc("xor", rd.reg, rd.reg, new ASMImm(1)));
                    }
                }
            } else if (irIns instanceof IRLoad irLoad) {
                var src = getAsmVar(irLoad.src);
                var des = getAsmVar(irLoad.des);
                regApply(src);
                regApply(des);
                curBlock.addIns(new ASMLw(des.reg, src.reg,new ASMImm(0)));
            } else if(irIns instanceof IRStore irStore){
                var src=getAsmVar(irStore.src);
                var des=getAsmVar(irStore.des);
                regApply(src);
                regApply(des);
                curBlock.addIns(new ASMSw(des.reg, src.reg,new ASMImm(0)));
            }else if(irIns instanceof IRRet irRet){

            }
        }
        return null;
    }

    public String irOptrans(IRCalc.IROp op) {
        return switch (op) {
            case plus -> "add";
            case minus -> "sub";
            case or -> "or";
            case and -> "and";
            case div -> "div";
            case mod -> "rem";
            case leftShift -> "sll";
            case rightShift -> "sra";
            case exclusiveOr -> "xor";
            default -> "";
        };
    }

}

package ASM;

import ASM.ASMIns.*;
import ASM.ASMutility.ASMGlob;
import ASM.ASMutility.ASMImm;
import ASM.ASMutility.ASMStack;
import ASM.ASMutility.ASMVar;
import AST.ASNBinaryExpr;
import IR.IRBlock;
import IR.IRFunction;
import IR.IRIns.*;
import IR.IRUtility.IRVar;

import java.util.*;

import static ASM.ASMutility.ASMImm.base;
import static ASM.ASMutility.ASMVar.*;
import static ASM.ASMutility.ASMVar.regName.*;
import static java.lang.Math.abs;

public class ASMFunction {
    public String funcName;
    public LinkedList<ASMBlock> blocks = new LinkedList<>();
    public Map<IRVar, ASMVar> varMapping = new LinkedHashMap<>();
    public Map<IRBlock, ASMBlock> blockMapTable = new LinkedHashMap<>();
    public int stackOffset = 0;
    ASMBlock curBlock;
    Random r = new Random();
    ASMBlock funcEndBlock;

    int lastRename = -1;
    int sublastRename = -1;

    public List<regName> availableReg = List.of(t0, t1, t2, t3, t4, t5, t6, a0, a1, a2, a3, a4, a5, a6, a7);
    public List<regName> callSaveReg = List.of(t0, t1, t2, t3, t4, t5, t6);
    public LinkedHashMap<ASMVar.regName, ASMVar> regRenameTable = new LinkedHashMap<>();

    public void resetRename() {
        for (var avalReg : availableReg) {
            regRenameTable.put(avalReg, null);
        }
    }

    public void regApply(ASMVar var) {
        if (var.reg == null || !var.equals(regRenameTable.get(var.reg))) {
            int pos;
            do {
                pos = abs(r.nextInt()) % availableReg.size();
            } while (pos == lastRename || pos == sublastRename);
            lastRename = pos;
            sublastRename = lastRename;
            var storeVar = regRenameTable.get(availableReg.get(pos));
            restoreVar(storeVar);
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

    public void loadFromMem(ASMVar var, regName des) {
        var.reg = des;
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

    public void restoreVar(ASMVar storeVar) {
        if (storeVar != null && !storeVar.ifTmp)
            switch (storeVar.genre) {
                case STACK -> {
                    curBlock.addIns(new ASMSw(sp, storeVar.reg, new ASMImm(((ASMStack) storeVar).offset)));
                }
                case GLOBAl -> {
                    var tmpVar = new ASMVar();
                    tmpVar.ifTmp = true;
                    regApply(tmpVar);
                    curBlock.addIns(new ASMLui(tmpVar.reg, storeVar));
                    curBlock.addIns(new ASMSw(tmpVar.reg, storeVar.reg, storeVar));
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
                var curVar = new ASMStack();
                curVar.offset = stackOffset;
                stackOffset += 4;
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
        curBlock = initBlock;
        for (int i = irFunc.paras.size() - 1; i >= 0; --i) {
            var para = irFunc.paras.get(i);
            var curVar = new ASMStack();
            if (i > 8) {
                curVar.offset = 4 * (i - 8);
            } else if (i == 8) {
                curVar.offset = 0;
                stackOffset = 4 * (irFunc.paras.size() - 8);
            } else {
                curVar.reg = regName.valueOf("a" + i);
                regRenameTable.put(curVar.reg, curVar);
                curVar.offset = stackOffset;
                stackOffset += 4;
            }
            varMapping.put(para, curVar);
        }
        blocks.add(initBlock);
        ++blockCount;
        for (var irBlock : irFunc.blocks) {
            var asmBlock = new ASMBlock(blockCount, this);
            blockMapTable.put(irBlock, asmBlock);
            blocks.add(asmBlock);
            ++blockCount;
        }
        funcEndBlock = new ASMBlock(blockCount, this);
        for (int i = 0; i < irFunc.blocks.size(); ++i) {
            curBlock = blocks.get(i + 1);
            blockBuild(blocks.get(i + 1), irFunc.blocks.get(i));
        }
        initBlock.addIns(new ASMCalc("add",sp,sp,new ASMImm(-stackOffset-4)));
        initBlock.addIns(new ASMSw(sp,ra,new ASMImm(stackOffset)));
        funcEndBlock.addIns(new ASMLw(ra,sp,new ASMImm(stackOffset)));
        funcEndBlock.addIns(new ASMCalc("add",sp,sp,new ASMImm(stackOffset+4)));
        funcEndBlock.addIns(new ASMRet());
        blocks.add(funcEndBlock);
    }

    public void blockBuild(ASMBlock curBlock, IRBlock irBlock) {
        for (var irIns : irBlock.insList) {
            if (irIns instanceof IRCalc irCalc) {
                var rs1 = getAsmVar(irCalc.lhs);
                var rs2 = getAsmVar(irCalc.rhs);
                var rd = getAsmVar(irCalc.des);
                loadFromMem(rs1, t0);
                loadFromMem(rs2, t1);
                rd.reg = t1;
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
                restoreVar(rd);
            } else if (irIns instanceof IRLoad irLoad) {
                var src = getAsmVar(irLoad.src);
                var des = getAsmVar(irLoad.des);
                if (!(src instanceof ASMGlob)) loadFromMem(src, t1);
                loadFromMem(des, t0);
                if (src.ifAlloca) {
                    curBlock.addIns(new ASMMv(des.reg, src.reg));
                } else if (src instanceof ASMGlob) {
                    curBlock.addIns(new ASMLw(des.reg, src));
                } else curBlock.addIns(new ASMLw(des.reg, src.reg, new ASMImm(0)));
                restoreVar(des);
            } else if (irIns instanceof IRStore irStore) {
                var src = getAsmVar(irStore.src);
                var des = getAsmVar(irStore.des);
                loadFromMem(src, t1);
                loadFromMem(des, t0);
                if (des.ifAlloca) {
                    curBlock.addIns(new ASMMv(des.reg, src.reg));
                } else if (des instanceof ASMGlob) {
                    var luiIns = new ASMLui(des.reg, des);
                    var storeIns = new ASMSw(des.reg, src.reg, des);
                    curBlock.addIns(luiIns);
                    curBlock.addIns(storeIns);
                } else curBlock.addIns(new ASMSw(des.reg, src.reg, new ASMImm(0)));
                restoreVar(des);
            } else if (irIns instanceof IRRet irRet) {
                if (irRet.returnVar != null) {
                    var ret = getAsmVar(irRet.returnVar);
                    loadFromMem(ret, a0);
//                    curBlock.addIns(new ASMMv(a0, ret.reg));
                }
                curBlock.addIns(new ASMJ(funcEndBlock));
            } else if (irIns instanceof IRGetPtr irGetPtr) {
                var src = getAsmVar(irGetPtr.src);
                var indexes = irGetPtr.indexes;
                if (indexes.size() == 1) {
                    var offset = new ASMImm(irGetPtr.src.type.deref().size);
                    var loc = getAsmVar(irGetPtr.indexes.get(0));
//                    regApply(loc);
//                    regApply(offset);
                    loadFromMem(loc, t0);
                    loadFromMem(offset, t1);
                    curBlock.addIns(new ASMCalc("mul", offset.reg, offset.reg, loc.reg));
                    loadFromMem(src, t2);
                    var des = getAsmVar(irGetPtr.des);
                    des.reg = t0;
                    curBlock.addIns(new ASMCalc("add", des.reg, src.reg, offset.reg));
                    restoreVar(des);
                } else {
                    assert indexes.size() == 2;
                    var offset = new ASMImm(irGetPtr.src.type.deref().size);
                    var loc = getAsmVar(irGetPtr.indexes.get(0));
                    loadFromMem(loc, t0);
                    loadFromMem(offset, t1);
                    curBlock.addIns(new ASMCalc("mul", offset.reg, offset.reg, loc.reg));
                    loadFromMem(src, t2);
                    var des = getAsmVar(irGetPtr.des);
                    des.reg = t0;
                    curBlock.addIns(new ASMCalc("add", des.reg, src.reg, offset.reg));
                    var structOffset = new ASMImm(irGetPtr.structOffset);
                    loadFromMem(structOffset, t1);
                    curBlock.addIns(new ASMCalc("add", des.reg, des.reg, structOffset.reg));
                    restoreVar(des);
                }
            } else if (irIns instanceof IRAlloca irAlloca) {
                var asmVar = getAsmVar(irAlloca.irVar);
                asmVar.ifAlloca = true;
            } else if (irIns instanceof IRCall irCall) {
                for (int i = 0; i < irCall.paras.size(); ++i) {
                    var para = getAsmVar(irCall.paras.get(i));
                    loadFromMem(para, t0);
                    if (i <= 7) {
                        curBlock.addIns((new ASMMv(regName.valueOf("a" + i), para.reg)));
                    } else {
                        curBlock.addIns(new ASMSw(sp, para.reg, new ASMImm(-(i - 8) * 4)));
                    }
                }
                curBlock.addIns(new ASMCall(irCall.funcName));
                if (irCall.returnVar != null) {
                    var ret = getAsmVar(irCall.returnVar);
                    ret.reg = a0;
                    restoreVar(ret);
                }
            } else if (irIns instanceof IRBitcast irBitcast) {
                var src = getAsmVar(irBitcast.srcVar);
                var des = getAsmVar(irBitcast.returnVar);
                loadFromMem(src, t1);
                des.reg = t0;
                curBlock.addIns(new ASMMv(des.reg, src.reg));
                restoreVar(des);
            } else if (irIns instanceof IRBr irBr) {
                curBlock.addIns(new ASMJ(blockMapTable.get(irBr.des)));
            } else if (irIns instanceof IRCondBr irCondBr) {
                var cond = getAsmVar(irCondBr.condition);
                loadFromMem(cond, t0);
                curBlock.addIns(new ASMBeqz(cond.reg, blockMapTable.get(irCondBr.des2)));
                curBlock.addIns(new ASMJ(blockMapTable.get(irCondBr.des1)));
            } else if (irIns instanceof IRPhi irPhi) {
                var des = getAsmVar(irPhi.des);
                var var1 = getAsmVar(irPhi.var1);
                var var2 = getAsmVar(irPhi.var2);
                var block = blockMapTable.get(irPhi.block1);
                var iter = block.block.listIterator(block.block.size());
                while (iter.hasPrevious()) {
                    var pr = iter.previous();
                    if (!(pr instanceof ASMJ || pr instanceof ASMBeqz)) {
                        iter.next();
                        break;
                    }
                }
                ASMBlock.insIter = iter;
                loadFromMem(var1,t1);
                loadFromMem(des,t0);
                curBlock.addIns(new ASMMv(des.reg, var1.reg));
                restoreVar(des);
                ASMBlock.insIter = null;
                 block = blockMapTable.get(irPhi.block2);
                 iter = block.block.listIterator(block.block.size());
                while (iter.hasPrevious()) {
                    var pr = iter.previous();
                    if (!(pr instanceof ASMJ || pr instanceof ASMBeqz)) {
                        iter.next();
                        break;
                    }
                }
                ASMBlock.insIter = iter;
                loadFromMem(var2,t1);
                loadFromMem(des,t0);
                curBlock.addIns(new ASMMv(des.reg, var2.reg));
                restoreVar(des);
                ASMBlock.insIter = null;
            }
        }
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

    public void callSaveRegApply(ASMVar var) {
        if (var.reg == null || !var.equals(regRenameTable.get(var.reg))) {
            int pos;
            do {
                pos = abs(r.nextInt()) % callSaveReg.size();
            } while (pos == lastRename || pos == sublastRename);
            lastRename = pos;
            sublastRename = lastRename;
            var storeVar = regRenameTable.get(availableReg.get(pos));
            restoreVar(storeVar);
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

}

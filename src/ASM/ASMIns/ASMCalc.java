package ASM.ASMIns;

import ASM.ASMutility.ASMGlob;
import ASM.ASMutility.ASMImm;
import ASM.ASMutility.ASMVar;
import ASM.ASMutility.ASMVar.*;
import IR.IRIns.IRIns;

public class ASMCalc extends ASMIns {
    public String op;

    public ASMCalc(String op_, regName rd_, regName rs1_, regName rs2_) {
        op = op_;
        rd = rd_;
        rs1 = rs1_;
        rs2 = rs2_;
    }

    public ASMCalc(String op_, regName rd_, regName rs1_, ASMVar imm_) {
        op = op_;
        rd = rd_;
        rs1 = rs1_;
        imm = imm_;
    }

    public ASMCalc(String op_, regName rd_, regName rs1_) {
        op = op_;
        rd = rd_;
        rs1 = rs1_;
    }


    public String toString() {
        if (imm != null) {
            if(imm instanceof ASMGlob)
                return String.format("%si\t%s, %s, %%lo(%s)", op, rd, rs1, imm);
            return String.format("%si\t%s, %s, %s", op, rd, rs1, imm);
        }
        else if (rs2 != null) return String.format("%s\t%s, %s, %s", op, rd, rs1, rs2);
        else return String.format("%s\t%s, %s", op, rd, rs1);
    }
}

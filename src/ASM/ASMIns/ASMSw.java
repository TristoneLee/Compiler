package ASM.ASMIns;

import ASM.ASMutility.ASMGlob;
import ASM.ASMutility.ASMVar;
import ASM.ASMutility.ASMVar.*;

public class ASMSw extends ASMIns {
    public ASMSw(regName rs1_, regName rs2_, ASMVar imm_){
        rs1=rs1_;
        rs2=rs2_;
        imm=imm_;
    }

    public String toString() {
        if (imm instanceof ASMGlob) return String.format("sw\t%s, %%lo(%s)%s", rs2, imm, rs1);
        else return String.format("sw\t%s, %s(%s)", rs2, imm, rs1);
    }
}

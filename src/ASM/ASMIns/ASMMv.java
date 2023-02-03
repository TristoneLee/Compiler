package ASM.ASMIns;

import ASM.ASMutility.ASMVar.*;

public class ASMMv extends ASMIns {
    public ASMMv (regName rd_,regName rs1_){
        rd=rd_;
        rs1=rs1_;
    }

    public String toString() {
        return String.format("mv\t%s, %s", rd, rs1);
    }
}

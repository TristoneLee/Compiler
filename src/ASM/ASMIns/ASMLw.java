package ASM.ASMIns;

import ASM.ASMutility.ASMGlob;
import ASM.ASMutility.ASMVar;
import ASM.ASMutility.ASMVar.*;

public class ASMLw extends ASMIns {
    public ASMLw(regName rd_, regName rs1_, ASMVar imm_){
        rd=rd_;
        rs1=rs1_;
        imm=imm_;
    }

    public ASMLw(regName rd_,ASMVar imm_){
        rd=rd_;
        imm=imm_;
    }

    public String toString() {
        if (imm instanceof ASMGlob)
            return String.format("lw\t%s, %s", rd, imm);
        else
            return String.format("lw\t%s, %s(%s)", rd, imm, rs1);

    }
}

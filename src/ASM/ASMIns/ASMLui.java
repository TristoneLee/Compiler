package ASM.ASMIns;

import ASM.ASMutility.ASMGlob;
import ASM.ASMutility.ASMVar;
import ASM.ASMutility.ASMVar.*;

public class ASMLui extends ASMIns {

    public ASMLui(regName rd_, ASMVar imm_) {
        rd=rd_;
        imm=imm_;
    }

    public String toString() {
        if (imm instanceof ASMGlob) return String.format("lui %s, %%hi(%s)", rd, imm);
        else return String.format("lui %s, %s", rd, imm);
    }
}

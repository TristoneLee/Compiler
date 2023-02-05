package ASM.ASMIns;

import ASM.ASMutility.ASMVar;
import ASM.ASMutility.ASMVar.*;

public class ASMLi extends ASMIns{
    public ASMLi(regName rd_, ASMVar imm_){
     rd=rd_;
     imm=imm_;
    }

    public String toString() {
        return String.format("li\t%s, %s", rd, imm);
    }
}

package ASM.ASMIns;

import ASM.ASMutility.ASMVar;

public class ASMLa extends ASMIns {
    public ASMLa(ASMVar.regName rd_, ASMVar imm_){
        rd=rd_;
        imm=imm_;
    }

    public String toString() {
        return String.format("la\t%s, %s", rd, imm);
    }
}

package ASM.ASMIns;

import ASM.ASMBlock;

public class ASMJ extends ASMIns {
    public ASMBlock dest;

    public ASMJ(){};

    public ASMJ(ASMBlock dest_){
        dest=dest_;
    }

    public String toString(){
        return String.format("j\t%s",dest.id());
    }
}

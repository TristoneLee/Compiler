package ASM.ASMIns;

import ASM.ASMFunction;
import IR.IRIns.IRIns;

public class ASMCall extends ASMIns {
    public String dest;

    public ASMCall(String dest_){
        dest=dest_;
    }
    public String toString(){
        return String.format("call\t%s",dest);
    }
}

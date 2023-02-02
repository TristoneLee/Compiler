package ASM.ASMIns;

import ASM.ASMFunction;
import IR.IRIns.IRIns;

public class ASMCall extends IRIns {
    public ASMFunction dest;

    public String toString(){
        return String.format("call\t%s",dest.funcName);
    }
}

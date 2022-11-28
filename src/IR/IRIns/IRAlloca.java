package IR.IRIns;

import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;

public class IRAlloca extends IRIns{
    IRVar irVar;
    int length;

    public IRAlloca(IRVar irVar_) {
        irVar = new IRVar(irVar_);
    }

    public String toString(){
        return "";
    }
}

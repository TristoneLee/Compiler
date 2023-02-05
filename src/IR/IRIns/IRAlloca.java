package IR.IRIns;

import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;

public class IRAlloca extends IRIns{
    public IRVar irVar;
    public int size;
    public IRType allocaType;

    public IRAlloca(IRVar irVar_) {
        irVar=irVar_;
        allocaType=irVar.type.deref();
    }


    public String toString(){
        return irVar.toString() + " = alloca "+irVar.type.deref().toString();
    }
}

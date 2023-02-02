package IR.IRIns;

import IR.IRUtility.IRVar;

public class IRLoad extends IRIns {
    public IRVar des=null;
    public IRVar src=null;

    @Override
    public String toString() {
        return des.toString()+"= load i32, "+src.toString();
    }
}

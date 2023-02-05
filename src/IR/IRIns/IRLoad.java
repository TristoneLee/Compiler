package IR.IRIns;

import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;

public class IRLoad extends IRIns {
    public IRVar des=null;
    public IRVar src=null;

    public IRLoad(){

    }

    public IRLoad(IRVar des_,IRVar src_){
        des=des_;
        src=src_;
    }

    @Override
    public String toString() {
        return des.toString()+"= load , "+src.toString();
    }
}

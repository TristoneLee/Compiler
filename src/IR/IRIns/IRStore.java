package IR.IRIns;

import IR.IRUtility.IRVar;

public class IRStore extends IRIns{
    IRVar des;
    IRVar src;

    public IRStore(IRVar des_,IRVar src_){
        des=new IRVar(des_);
        src=new IRVar(src_);
    }
}

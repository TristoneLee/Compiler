package IR.IRIns;

import IR.IRUtility.IRVar;

public class IRStore extends IRIns{
    public IRVar des;
    public IRVar src;

    public IRStore(){};

    public IRStore(IRVar des_,IRVar src_){
        des=new IRVar(des_);
        src=new IRVar(src_);
    }

    public String toString(){
        return "store "+src.toString()+", "+des.toString();
    }
}

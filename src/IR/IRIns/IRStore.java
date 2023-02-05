package IR.IRIns;

import IR.IRUtility.IRVar;

public class IRStore extends IRIns{
    public IRVar des;
    public IRVar src;

    public IRStore(){};

    public IRStore(IRVar des_,IRVar src_){
        des=des_;
        src=src_;
    }

    public String toString(){
        return "store "+src.toString()+", "+des.toString();
    }
}

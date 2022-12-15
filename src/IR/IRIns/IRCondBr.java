package IR.IRIns;

import IR.IRUtility.IRVar;

public class IRCondBr extends IRIns{
    IRVar condition;
    int des1;
    int des2;

    public IRCondBr(IRVar cond,int des1_,int des2_){
        condition=new IRVar(cond);
        des1=des1_;
        des2=des2_;
    }
}

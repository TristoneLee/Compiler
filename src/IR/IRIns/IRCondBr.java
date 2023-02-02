package IR.IRIns;

import IR.IRUtility.IRVar;

public class IRCondBr extends IRIns{
    IRVar condition;
    Integer des1;
    Integer des2;

    public IRCondBr(IRVar cond,int des1_,int des2_){
        condition=new IRVar(cond);
        des1=des1_;
        des2=des2_;
    }

    public String toString(){
        return "br "+condition.toString()+", lable "+des1.toString()+", lable "+des2.toString();
    }
}

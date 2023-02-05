package IR.IRIns;

import IR.IRBlock;
import IR.IRUtility.IRVar;

public class IRCondBr extends IRIns{
    public IRVar condition;
    public IRBlock des1;
    public IRBlock des2;

    public IRCondBr(IRVar cond,IRBlock des1_,IRBlock des2_){
        condition=cond;
        des1=des1_;
        des2=des2_;
    }

    public String toString(){
        return String.format("br %s, block %s, block %s",condition,des1.index,des2.index);
    }
}

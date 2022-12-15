package IR;

import IR.IRIns.IRIns;

import java.util.List;

public class IRBlock {
    public List<IRIns> ins;
    public int continueBlock;
    public int breakBlock;

    public void add(IRIns irIns){
        ins.add(irIns);
    }

    public String toString(){

    }
}

package IR;

import IR.IRIns.IRIns;

import java.util.ArrayList;
import java.util.List;

public class IRBlock {
    public List<IRIns> insList=new ArrayList<>();
    public IRBlock continueBlock;
    public IRBlock breakBlock;
    public Integer index;

    public void add(IRIns irIns){
        insList.add(irIns);
    }

    public String toString(){
        String string="";
        for(var ins:insList){
            string=string+ins.toString()+'\n';
        }
        return string;
    }

    public void print(){
        System.out.print(this);
    }
}

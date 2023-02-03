package ASM;

import ASM.ASMIns.ASMIns;

import java.util.LinkedList;
import java.util.ListIterator;

public class ASMBlock {
    public int index;
    public ASMFunction srcFunc;
    public LinkedList<ASMIns> block=new LinkedList<>();
    public LinkedList<ASMBlock> ante=new LinkedList<>();
    public LinkedList<ASMBlock> desc=new LinkedList<>();
    public static ListIterator<ASMIns> insIter= null;

    public ASMBlock(int index_, ASMFunction srcFun_){
        index=index_;
        srcFunc=srcFun_;
    }

    public void resetIter(){
        insIter= block.listIterator(0);
    }
    public void addIns(ASMIns ins_){
        if(insIter!=null)insIter.add(ins_);
        else block.add(ins_);
    }
    public void setAnte(ASMBlock block_){
        ante.add(block_);
    }
    public void setDesc(ASMBlock block_){
        desc.add(block_);
    }

    public String id(){
        return srcFunc.funcName+".block"+index;
    }
}

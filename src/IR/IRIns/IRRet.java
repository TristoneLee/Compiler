package IR.IRIns;

import IR.IRUtility.IRVar;

public class IRRet extends IRIns{
    IRVar returnVar;

    public IRRet(IRVar returnVar_){
        returnVar=returnVar_;
    }

    public IRRet(){
        returnVar=null;
    }

    public String toString(){
        if(returnVar==null){
            return "ret void";
        }
        else return "ret "+returnVar.toString();
    }
}

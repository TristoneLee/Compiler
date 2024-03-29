package IR.IRIns;

import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;

public class IRBitcast extends IRIns{
    public IRVar returnVar;
    public IRVar srcVar;

    public IRBitcast(){}

    public IRBitcast(IRVar returnVar_,IRVar srcVar_){
        returnVar=returnVar_;
        srcVar=srcVar_;
    }

    public String toString(){
        return String.format("%s = bitcast %s %s to %s", returnVar, srcVar.type, srcVar, returnVar.type);
    }
}

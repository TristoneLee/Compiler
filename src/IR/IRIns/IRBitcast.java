package IR.IRIns;

import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;

public class IRBitcast extends IRIns{
    public IRVar returnVar;
    public IRVar srcVar;
    public IRType desType;

    public String toString(){
        return String.format("%s = bitcast %s %s to %s", returnVar, srcVar.type, srcVar, desType);
    }
}

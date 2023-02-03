package IR.IRIns;

import IR.IRStruct;
import IR.IRUtility.IRVar;

import java.util.LinkedList;

public class IRGetPtr extends IRIns{
    public IRVar des=null;
    public IRVar src=null;
    public LinkedList<IRVar> indexes=new LinkedList<>();
    public int structOffset;

    @Override
    public String toString() {
        String retString=des.toString()+" = getelementptr "+src.toString();
        for(var index:indexes){
            retString=retString+", "+index.toString();
        }
        return retString;
    }
}

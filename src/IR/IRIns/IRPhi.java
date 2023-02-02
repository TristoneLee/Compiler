package IR.IRIns;

import IR.IRBlock;
import IR.IRUtility.IRVar;
import org.antlr.v4.runtime.misc.Pair;

import java.util.LinkedList;

public class IRPhi extends IRIns{
    public LinkedList<Pair<IRBlock, IRVar>> phiCases = new LinkedList<>();

    public void add(IRBlock block,IRVar var){
        phiCases.add(new Pair<>(block,var));
    }
}

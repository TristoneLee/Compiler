package IR.IRIns;

import IR.IRBlock;
import IR.IRUtility.IRVar;
import org.antlr.v4.runtime.misc.Pair;

import java.util.LinkedList;

public class IRPhi extends IRIns {
    public IRVar des;
    public IRBlock block1;
    public IRVar var1;
    public IRBlock block2;
    public IRVar var2;

    public IRPhi(IRVar des_, IRBlock block1, IRVar var1, IRBlock block2, IRVar var2) {
        des = des_;
        this.block1=block1;
        this.var1=var1;
        this.block2=block2;
        this.var2=var2;
    }

    public String toString() {
        return String.format("%s = phi [ %s, block%s ], [%s, block%s ]", des, var1, block1.index, var2, block2.index);
    }
}

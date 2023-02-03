package IR.IRIns;

import IR.IRBlock;

public class IRBr extends IRIns{
    public IRBlock des;

    public IRBr(IRBlock des_) {
        des=des_;
    }

    @Override
    public String toString() {
        return String.format("br block %s",des.index);
    }
}

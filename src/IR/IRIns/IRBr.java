package IR.IRIns;

public class IRBr extends IRIns{
    int des;

    public IRBr(int des_) {
        des=des_;
    }

    @Override
    public String toString() {
        return "br "+des+"";
    }
}

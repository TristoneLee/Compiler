package IR.IRIns;

import IR.IRUtility.IRVar;

public class IRCalc extends IRIns{
    public enum IROp {
        plus, minus, star, div, mod, less, lessEqual, greaterEqual, greater, leftShift,
        rightShift, and, or, logicalAnd, logicalOr, equal, notEqual, assign, exclusiveOr
    }

    public IRVar rhs;
    public IRVar lhs;
    public IROp op;
    public IRVar des;

    public IRCalc(IRVar lhsVar_, IRVar rhsVar_, IRVar desVar_,IROp op_) {
        rhs=new IRVar(rhsVar_);
        lhs=new IRVar(lhsVar_);
        des=new IRVar(desVar_);
        op=op_;
    }

    public String toString(){
        return des.toString()+" = "+lhs
    }
}

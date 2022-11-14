package IR.IRIns;

import IR.IRUtility.IRVar;

public class IRCalc {
    public enum IROp {
        plus, minus, star, div, mod, leftShift, rightShift, and, or, logicalAnd, logicalOr, equal, notEqual, exclusiveOr
    }

    IRVar rhs;
    IRVar lhs;
    IROp op;
}

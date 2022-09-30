package src.AST;

public class ASNBinaryExpr extends ASN {
    // 1:lhs 2:rhs
    public enum Operate{add,sub,mul,div,mod,less,lessEqual,greaterEqual,greater,lefyShift,
    rightShift,and,or,logicalAnd,logicalOr,equal,notEqual,assign,exclusiveOr}

    Operate op;

    ASNBinaryExpr(String text_,Operate op_) {
        super(text_);
    }
}

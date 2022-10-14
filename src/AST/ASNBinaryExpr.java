package src.AST;

public class ASNBinaryExpr extends ASNExpr {
    // 1:lhs 2:rhs
    public enum Operate{
        plus, minus, star,div,mod,less,lessEqual,greaterEqual,greater, leftShift,
    rightShift,and,or,logicalAnd,logicalOr,equal,notEqual,assign,exclusiveOr}

    public ASNExpr lhs,rhs;

    Operate op;
    public ASNBinaryExpr(Operate op_) {
        super("BinaryExpression");
    }

    public void build(){
        lhs= (ASNExpr) children.get(0);
        rhs= (ASNExpr) children.get(1);
    }
}

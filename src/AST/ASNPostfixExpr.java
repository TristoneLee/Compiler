package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;

import static utility.ValueType.IntegerType;

public class ASNPostfixExpr extends ASNExpr {
    public enum PostfixType {plusplus, minusminus}
    PostfixType type;
    ASNExpr expr;

    public ASNPostfixExpr(ScopeBuffer scopeBuffer, PostfixType _type) {
        super( scopeBuffer);
        type = _type;
    }


    @Override
    public void build() throws CompileException {
        expr= (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        expr.check();
        if(!expr.returnType.equals(IntegerType) ) throw new InvalidExpression();
        if(!expr.ifLeftValue) throw new InvalidExpression();
        returnType=IntegerType;
    }

}

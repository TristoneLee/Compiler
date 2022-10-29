package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidExpression;

import static src.utility.ValueType.IntegerType;

public class ASNPostfixExpr extends ASNExpr {
    public enum PostfixType {plusplus, minusminus}
    PostfixType type;
    ASNExpr expr;

    public ASNPostfixExpr(ScopeBuffer scopeBuffer, PostfixType _type) {
        super("PostfixExpr", scopeBuffer);
        type = _type;
    }


    @Override
    public void build() throws CompileException {
        expr= (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        expr.check();
        if(expr.returnType!= IntegerType) throw new InvalidExpression();
        returnType=IntegerType;
    }

}

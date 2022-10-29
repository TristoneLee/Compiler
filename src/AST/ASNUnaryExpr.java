package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidExpression;

import java.util.List;
import java.util.Stack;

import static src.utility.ValueType.BooleanType;
import static src.utility.ValueType.IntegerType;

public class ASNUnaryExpr extends ASNExpr{
    public enum UnaryOp{plusplus,minusminus,and,star,plus,minus,not,tilde}
    UnaryOp unaryOp;
    ASNExpr expr;

    public ASNUnaryExpr(ScopeBuffer scopeBuffer, UnaryOp op){
        super("ASNUnaryExpr",scopeBuffer);
        unaryOp=op;
    }

    @Override
    public void build() throws CompileException {
        expr= (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        expr.check();
       if(unaryOp==UnaryOp.not) {
           if(!expr.returnType.equals(BooleanType)) throw new InvalidExpression();
       }else if (!expr.returnType.equals(IntegerType)) throw new InvalidExpression();
       returnType=expr.returnType;
    }
}

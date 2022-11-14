package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;

import java.util.List;
import java.util.Stack;

import static utility.ValueType.BooleanType;
import static utility.ValueType.IntegerType;

public class ASNUnaryExpr extends ASNExpr{
    public enum UnaryOp{plusplus,minusminus,and,star,plus,minus,not,tilde}
    UnaryOp unaryOp;
    ASNExpr expr;

    public ASNUnaryExpr(ScopeBuffer scopeBuffer, UnaryOp op){
        super(scopeBuffer);
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
       if((unaryOp==UnaryOp.plusplus||unaryOp==UnaryOp.minusminus)&& !expr.ifLeftValue)  throw new InvalidExpression();
       returnType=expr.returnType;
       if(unaryOp==UnaryOp.plusplus||unaryOp==UnaryOp.minusminus) ifLeftValue=true;
    }
}

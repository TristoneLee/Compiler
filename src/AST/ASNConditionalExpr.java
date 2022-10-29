package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;

import static utility.ValueType.BooleanType;
import static utility.ValueType.IntegerType;

public class ASNConditionalExpr extends ASNExpr{
    ASNExpr case1,case2,condition;

    public ASNConditionalExpr(ScopeBuffer scopeBuffer){
        super("ConditionalExpr",scopeBuffer);
    }

    @Override
    public void build() throws CompileException{
        condition= (ASNExpr) children.get(0);
        case1= (ASNExpr) children.get(1);
        case2= (ASNExpr) children.get(2);
    }

    @Override
    public void check() throws CompileException {
        condition.check();
        case1.check();
        case2.check();
        if(condition.returnType!=BooleanType) throw new InvalidExpression();
        else if(case1.returnType!=case2.returnType) throw new InvalidExpression();
        else returnType=case1.returnType;
    }
}

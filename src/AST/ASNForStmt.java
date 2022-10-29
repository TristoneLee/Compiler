package AST;

import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;
import utility.ValueType;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static utility.ValueType.BooleanType;

public class ASNForStmt extends ASNStmt {
    ASNForExpr1 forExpr1;
    ASNExpr forExpr2;
    ASNExpr forExpr3;
    ASNStmt forStmt;

    public ASNForStmt(ScopeBuffer scopeBuffer) {
        super("ForStmt", scopeBuffer);
    }

    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNStmt) forStmt = (ASNStmt) child;
            else if (child instanceof ASNForExpr2) forExpr2 = ((ASNForExpr2) child).expr;
            else if (child instanceof ASNForExpr3) forExpr3 = ((ASNForExpr3) child).expr;
            else if(child instanceof ASNForExpr1) forExpr1= (ASNForExpr1) child;
            else throw new InvalidExpression();
        }
    }

    public void check() throws CompileException{
        scopeBuffer.push(new Scope());
        scopeBuffer.addVariable("loopppppp",new ValueType());
        if(forExpr1!=null)forExpr1.check();
        if(forExpr2!=null)forExpr2.check();
        if(forExpr3!=null)forExpr3.check();
        if(forExpr2!=null&&forExpr2.returnType!=BooleanType) throw new InvalidExpression();
        forStmt.check();
        scopeBuffer.pop();
    }
}

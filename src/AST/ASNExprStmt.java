package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.List;
import java.util.Stack;

public class ASNExprStmt extends ASNStmt{
    ASNExpr expr;

    public ASNExprStmt(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        if(!children.isEmpty()) expr= (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        if(expr!=null)expr.check();
    }
}

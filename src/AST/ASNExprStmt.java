package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import java.util.List;
import java.util.Stack;

public class ASNExprStmt extends ASNStmt{
    ASNExpr expr;

    public ASNExprStmt(ScopeBuffer scopeBuffer){
        super("ExprStmt",scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        if(!children.isEmpty()) expr= (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        expr.check();
    }
}

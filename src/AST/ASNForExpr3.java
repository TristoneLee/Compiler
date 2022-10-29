package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import java.util.List;
import java.util.Stack;

public class ASNForExpr3 extends ASNExpr{
    ASNExpr expr;

    public ASNForExpr3 (ScopeBuffer scopeBuffer){
        super("ForExpr3",scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        expr= (ASNExpr) children.get(0);
    }
}

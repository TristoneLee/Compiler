package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import java.util.List;
import java.util.Stack;

public class ASNForExpr2 extends ASNExpr{
    ASNExpr expr;
    public ASNForExpr2 (ScopeBuffer scopeBuffer){
        super("ForExpr2",scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        expr= (ASNExpr) children.get(0);
    }


}

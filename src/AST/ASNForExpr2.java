package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.List;
import java.util.Stack;

public class ASNForExpr2 extends ASNExpr{
    ASNExpr expr;
    public ASNForExpr2 (ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        expr= (ASNExpr) children.get(0);
    }

}

package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import java.util.ArrayList;

public class ASNArrayId extends  ASNExpr{
    ASNExpr expr;

    public ASNArrayId(ScopeBuffer scopeBuffer) {
        super("ArrayId", scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        expr= (ASNExpr) children.get(0);
    }

}

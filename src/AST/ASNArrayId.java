package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;

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

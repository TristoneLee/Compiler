package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

public class ASNForExpr1 extends ASN{
    ASN expr;

    public ASNForExpr1 (ScopeBuffer scopeBuffer){
        super("ForExpr1",scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        expr=children.get(0);
    }

    @Override
    public void check() throws CompileException {
        expr.check();
    }
}

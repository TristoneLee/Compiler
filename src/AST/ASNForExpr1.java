package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;

public class ASNForExpr1 extends ASN{
    ASN expr;

    public ASNForExpr1 (ScopeBuffer scopeBuffer){
        super("ForExpr1",scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        if(children.size()!=0)expr=children.get(0);
    }

    @Override
    public void check() throws CompileException {
        if(expr!=null)expr.check();
    }
}

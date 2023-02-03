package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;

public class ASNForExpr1 extends ASNStmt{
    public ASN expr;

    public ASNForExpr1 (ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        if(children.size()!=0)expr=children.get(0);
    }

    @Override
    public void check() throws CompileException {
        if(expr!=null)expr.check();
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        return expr.irGeneration(irBuilder, irFunction);
    }
}

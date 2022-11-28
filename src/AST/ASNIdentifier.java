package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.UndeifinedVariety;

public class ASNIdentifier extends ASNExpr{
    String identifier;

    public ASNIdentifier(String text, ScopeBuffer scopeBuffer){
        super(scopeBuffer);
        identifier=text;
        ifLeftValue=true;
    }

    @Override
    public void build() throws CompileException {
        super.build();
    }

    @Override
    public void check() throws CompileException {
        returnType=scopeBuffer.searchVar(identifier);
        if(returnType==null) throw new UndeifinedVariety();
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        return irBuilder.irScopeStack.searchVar(identifier);
    }
}

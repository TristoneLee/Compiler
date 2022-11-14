package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.UndeifinedVariety;

import java.util.List;
import java.util.Stack;

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
}

package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.UndeifinedVariety;

import java.util.List;
import java.util.Stack;

public class ASNIdentifier extends ASNExpr{
    String identifier;

    public ASNIdentifier(String text, ScopeBuffer scopeBuffer){
        super("Identifier",scopeBuffer);
        identifier=text;
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

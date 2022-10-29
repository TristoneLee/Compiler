package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import java.util.List;

public class ASNThis extends ASNExpr{
    public ASNThis(ScopeBuffer scopeBuffer){
        super("This", scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        returnType=scopeBuffer.searchVar("this");
        if(returnType==null) throw new CompileException("InvalidUseOfThis");
    }
}

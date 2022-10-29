package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import static src.utility.ValueType.NullType;


public class ASNNull extends ASNExpr{
    public ASNNull(ScopeBuffer scopeBuffer){
        super("ASNNull",scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        returnType= NullType;
    }
}

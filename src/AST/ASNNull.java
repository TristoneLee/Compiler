package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;

import static utility.ValueType.NullType;


public class ASNNull extends ASNExpr{
    public ASNNull(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        returnType= NullType;
    }
}

package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
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

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        return new IRVar(0, IRType.Genre.I32);
    }
}

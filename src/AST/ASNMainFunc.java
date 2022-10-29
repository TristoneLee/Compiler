package AST;

import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Parameter;

import static utility.ValueType.IntegerType;

public class ASNMainFunc extends ASNFuncDec{
    ASNMainFunc(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        super.build();
    }

    @Override
    public void check() throws CompileException {
        if(entity.returnType!=IntegerType) throw new CompileException("InvalidMainFunction");
        super.check();
    }
}

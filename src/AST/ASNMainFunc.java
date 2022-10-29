package src.AST;

import src.parser.Scope;
import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Parameter;

import static src.utility.ValueType.IntegerType;

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

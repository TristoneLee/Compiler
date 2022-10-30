package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.List;

public class ASNThis extends ASNExpr{
    public ASNThis(ScopeBuffer scopeBuffer){
        super("This", scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        ASNClassDel classDelNode=scopeBuffer.searchClassControl();
        if(classDelNode==null)  throw new CompileException("InvalidUseOfThis");
        else returnType=new ValueType(classDelNode.classEntity.className);
    }
}

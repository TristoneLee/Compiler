package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

public class ASNThis extends ASNExpr{
    public ASNThis(ScopeBuffer scopeBuffer){
        super( scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        ASNClassDel classDelNode=scopeBuffer.searchClassControl();
        if(classDelNode==null)  throw new CompileException("InvalidUseOfThis");
        else returnType=new ValueType(classDelNode.classEntity.className);
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
            return irBuilder.irScopeStack.searchVar("this");
    }
}

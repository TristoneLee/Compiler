package AST;

import com.sun.jdi.VoidType;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.Stack;

public class ASNClassConstructorDec extends ASNFuncDec{
    String className;

    public ASNClassConstructorDec(ScopeBuffer scopeBuffer) {
        super( scopeBuffer);
        entity.returnType= ValueType.VoidType;
    }

    @Override
    public void build() throws CompileException {
        entity.asnFuncDec=this;
        for(ASN child:children){
            if(child instanceof ASNIdentifier) {
                className =  ((ASNIdentifier) child).identifier;
                entity.functionName ="Constructor";
                entity.returnType= ValueType.VoidType;
            }
            else if(child instanceof ASNFuncBody) funcBody=(ASNFuncBody) child;
        }
    }

    @Override
    public void check() throws CompileException {
        if(!scopeBuffer.searchClassControl().classEntity.className.equals(className))throw new CompileException("UnmatchedClassConstructor");
        super.check();
    }

}

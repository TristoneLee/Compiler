package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.Stack;

public class ASNClassConstructorDec extends ASNStmt{
    String className;
    ASNFuncBody funcBody;

    public ASNClassConstructorDec(ScopeBuffer scopeBuffer) {
        super("ClassConstructorDec", scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        for(ASN child:children){
            if(child instanceof ASNIdentifier) className=((ASNIdentifier) child).identifier;
            else if(child instanceof ASNFuncBody) funcBody=(ASNFuncBody) child;
        }
    }

    @Override
    public void check() throws CompileException {
        funcBody.check();
    }
}

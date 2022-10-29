package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.ValueType;

import java.util.List;
import java.util.Stack;

public class ASNInitDeclarator extends ASN{
    ValueType returnType;
    String name;
    ASNExpr initor;

    public ASNInitDeclarator(String name_, ScopeBuffer scopeBuffer) {
        super("InitDeclarator", scopeBuffer);
        name=name_;
    }

    @Override
    public void build() throws CompileException {
        if(!children.isEmpty()) initor= (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        if(initor!=null) {
            initor.check();
            returnType = initor.returnType;
        }
    }
}

package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.List;
import java.util.Stack;

public class ASNInitDeclarator extends ASN{
    ValueType returnType;
    String name;
    ASNExpr initor;

    public ASNInitDeclarator(String name_, ScopeBuffer scopeBuffer) {
        super( scopeBuffer);
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

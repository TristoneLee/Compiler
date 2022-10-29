package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import java.util.List;
import java.util.Stack;

public class ASNTransUnit extends ASN{
    public ASNTransUnit(ScopeBuffer scopeBuffer) {
        super("TransUnit",scopeBuffer);
    }

    @Override
    public void check() throws CompileException {
        for(ASN child:children){
            child.check();
        }
    }
}

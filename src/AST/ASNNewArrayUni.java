package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidArrayType;

public class ASNNewArrayUni extends ASN{
    ASNExpr expr;

    public ASNNewArrayUni(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    public void build() throws CompileException {
        if(children.isEmpty()) expr=null;
        else{
            expr= (ASNExpr) children.get(0);
        }
    }
}

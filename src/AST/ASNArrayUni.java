package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidArrayType;

import java.util.List;
import java.util.Stack;

public class ASNArrayUni extends ASN{
     int num;

    public ASNArrayUni(ScopeBuffer scopeBuffer){
        super("ArrayUni",scopeBuffer);
    }

    public void build() throws CompileException {
        if(children.isEmpty()) num=0;
        else{
            num=((ASNIntConst)children.get(0)).value;
            if(num<=0) throw new InvalidArrayType();
        }
    }
}

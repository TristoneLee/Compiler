package src.AST;

import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidArrayType;

public class ASNArrayUni extends ASN{
     int num;

    public ASNArrayUni(){
        super("ArrayUni");
    }

    public void build() throws CompileException {
        if(children.isEmpty()) num=0;
        else{
            num=((ASNIntConst)children.get(0)).value;
            if(num<=0) throw new InvalidArrayType();
        }
    }
}

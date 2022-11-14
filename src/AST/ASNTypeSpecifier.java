package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidArrayType;
import utility.ValueType;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ASNTypeSpecifier extends ASN {
    ValueType valueType;

    public ASNTypeSpecifier(ScopeBuffer scopeBuffer) {
        super( scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNStringConst) valueType =new ValueType (((ASNStringConst) child).value);
            else if (child instanceof ASNArrayUni) {
                ++valueType.dimension;
                valueType.dimensions.add(((ASNArrayUni) child).num);
            }
        }
        check();
    }

    @Override
    public void check() throws CompileException {
        if (valueType.baseType.equals("void")  && valueType.dimension != 0) throw new InvalidArrayType();
        boolean flag=false;
        for(int i:valueType.dimensions){
            if(i==0) flag=true;
            else if (flag) throw new InvalidArrayType();
        }
    }
}

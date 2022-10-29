package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidArrayType;
import src.utility.ValueType;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ASNTypeSpecifier extends ASN {

    ValueType valueType;

    public ASNTypeSpecifier(ScopeBuffer scopeBuffer) {
        super("TypeSpecifier", scopeBuffer);
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
    }

    @Override
    public void check() throws CompileException {
        if (valueType.baseType == "void" && valueType.dimension != 0) throw new InvalidArrayType();
    }
}

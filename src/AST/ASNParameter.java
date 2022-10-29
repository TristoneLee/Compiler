package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Parameter;

import java.util.Objects;

public class ASNParameter extends ASN {
    Parameter parameter;
    ASNTypeSpecifier typeSpecifier;
    public ASNParameter(ScopeBuffer scopeBuffer) {
        super("Parameter", scopeBuffer);
        parameter=new Parameter();
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (Objects.equals(child.type, "StringConst")) {
                parameter.name = ((ASNStringConst) child).value;
            } else if (Objects.equals(child.type, "TypeSpecifier")) {
                parameter.valueType.dimension = ((ASNTypeSpecifier) child).valueType.dimension;
                parameter.valueType.dimensions = ((ASNTypeSpecifier) child).valueType.dimensions;
                parameter.valueType.baseType = ((ASNTypeSpecifier) child).valueType.baseType;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        typeSpecifier.check();
    }
}

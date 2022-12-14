package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Parameter;

import java.util.Objects;

public class ASNParameter extends ASN {
    Parameter parameter;
    ASNTypeSpecifier typeSpecifier;

    public ASNParameter(ScopeBuffer scopeBuffer) {
        super( scopeBuffer);
        parameter = new Parameter();
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNStringConst) {
                parameter.name = ((ASNStringConst) child).value;
            } else if (child instanceof ASNTypeSpecifier) {
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

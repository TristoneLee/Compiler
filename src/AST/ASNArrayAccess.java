package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;
import utility.Exception.UndeifinedVariety;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utility.ValueType.IntegerType;

public class ASNArrayAccess extends ASNExpr {
    List<ASNExpr> arrayIds;
    ASNExpr arrayIden;

    public ASNArrayAccess(ScopeBuffer scopeBuffer) {
        super("ArrayAccess", scopeBuffer);
        arrayIds = new ArrayList<>();
    }

    @Override
    public void build() {
        for (ASN child : children) {
            if (child instanceof ASNArrayId) {
                arrayIds.add(((ASNArrayId) child).expr);
            } else if (child instanceof ASNExpr) {
                arrayIden = (ASNExpr) child;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        for (ASNExpr arrayId : arrayIds) {
            arrayId.check();
            if (!arrayId.returnType.equals(IntegerType)) throw new InvalidExpression();
        }
        arrayIden.check();
        ValueType valueType = arrayIden.returnType;
        if (valueType == null) throw new UndeifinedVariety();
        if (valueType.dimension < arrayIds.size()) throw new InvalidExpression();
        returnType = new ValueType(valueType.baseType);
        returnType.dimensions = valueType.dimensions.subList(arrayIds.size(), valueType.dimensions.size());
        returnType.dimension = returnType.dimensions.size();
    }

}

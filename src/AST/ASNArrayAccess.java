package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidExpression;
import src.utility.Exception.UndeifinedVariety;
import src.utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static src.utility.ValueType.IntegerType;

public class ASNArrayAccess extends ASNExpr {
    List<ASNExpr> arrayIds;
    String arrayIden;

    public ASNArrayAccess(ScopeBuffer scopeBuffer) {
        super("ArrayAccess", scopeBuffer);
        arrayIds=new ArrayList<>();
    }

    @Override
    public void build() {
        for (ASN child : children) {
            if (child instanceof ASNIdentifier) {
                arrayIden = ((ASNIdentifier) child).identifier;
            } else if(child instanceof ASNArrayId){
                arrayIds.add( ((ASNArrayId) child).expr);
            }
        }
    }

    @Override
    public void check() throws CompileException {
        for (ASNExpr arrayId : arrayIds) {
            arrayId.check();
            if (!arrayId.returnType.equals(IntegerType)) throw new InvalidExpression();
        }
        ValueType valueType = scopeBuffer.searchVar(arrayIden);
        if(valueType==null) throw new UndeifinedVariety();
        if(valueType.dimension<arrayIds.size()) throw new InvalidExpression();
        returnType=new ValueType(valueType.baseType);
        returnType.dimensions=valueType.dimensions.subList(arrayIds.size(), valueType.dimensions.size());
        returnType.dimension=returnType.dimensions.size();
    }

}

package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRGetPtr;
import IR.IRIns.IRLoad;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;
import utility.Exception.UndeifinedVariety;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;

import static utility.ValueType.IntegerType;

public class ASNArrayAccess extends ASNExpr {

    List<ASNExpr> arrayIds = new ArrayList<>();
    ASNExpr idNode;
    String arrayIden;

    public ASNArrayAccess(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
        ifLeftValue = true;
    }

    @Override
    public void build() {
        for (ASN child : children) {
            if (child instanceof ASNArrayId) {
                arrayIds.add(((ASNArrayId) child).expr);
            } else if (child instanceof ASNExpr) {
                if(child instanceof ASNIdentifier) arrayIden= ((ASNIdentifier) child).identifier;
                idNode = (ASNExpr) child;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        for (ASNExpr arrayId : arrayIds) {
            arrayId.check();
            if (!arrayId.returnType.equals(IntegerType)) throw new InvalidExpression();
        }
        idNode.check();
        ValueType valueType = idNode.returnType;
        if (valueType == null) throw new UndeifinedVariety();
        if (valueType.dimension < arrayIds.size()) throw new InvalidExpression();
        returnType = new ValueType(valueType.baseType);
        returnType.dimensions = valueType.dimensions.subList(arrayIds.size(), valueType.dimensions.size());
        returnType.dimension = returnType.dimensions.size();
    }

    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        idNode.ifLoad=false;
        var srcVar = idNode.irGeneration(irBuilder,irFunction);
        for (var arrayId : arrayIds) {
            var getPtrIns = new IRGetPtr();
            getPtrIns.src = new IRVar(srcVar);
            getPtrIns.indexes.add(arrayId.irGeneration(irBuilder, irFunction));
            ++irFunction.localVarIndex;
            srcVar = new IRVar(new IRType(srcVar.type).deref(), irFunction.localVarIndex);
            getPtrIns.des = srcVar;
            irFunction.addIns( getPtrIns);
        }
        if(ifLoad){
            ++irFunction.localVarIndex;
            var valueVar=new IRVar(srcVar.type.deref(), irFunction.localVarIndex);
            var loadIns =new IRLoad();
            loadIns.src=srcVar;
            loadIns.des=valueVar;
            irFunction.addIns( loadIns);
            return valueVar;
        }
        else return srcVar;
    }
}

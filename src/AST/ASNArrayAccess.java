package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRGetPtr;
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
    ASNIdentifier idNode;
    String arrayIden;

    public ASNArrayAccess(ScopeBuffer scopeBuffer) {
        super( scopeBuffer);
        ifLeftValue=true;
    }

    @Override
    public void build() {
        for (ASN child : children) {
            if (child instanceof ASNArrayId) {
                arrayIds.add(((ASNArrayId) child).expr);
            } else if (child instanceof ASNExpr) {
                idNode = (ASNIdentifier) child;
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
        arrayIden=idNode.identifier;
    }

    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock){
        var srcVar=irBuilder.irScopeStack.searchVar(arrayIden);
        for (var arrayId:arrayIds){
            var getPtrIns = new IRGetPtr();
            getPtrIns.src=new IRVar(srcVar);
            srcVar=new IRVar(IntegerType,irFunction.localVarIndex);
            getPtrIns.num=arrayId.irGeneration(irBuilder,irFunction,curBlock);
            getPtrIns.des=srcVar;
            ++irFunction.localVarIndex;
            srcVar=new IRVar(IntegerType,irFunction.localVarIndex);
            irFunction.blocks.get(curBlock).add(getPtrIns);
        }
        return srcVar;
    }
}

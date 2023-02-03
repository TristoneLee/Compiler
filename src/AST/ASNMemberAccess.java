package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRCall;
import IR.IRIns.IRGetPtr;
import IR.IRIns.IRLoad;
import IR.IRStruct;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ClassEntity;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;

import java.util.List;

import static utility.ValueType.IntegerType;

public class ASNMemberAccess extends ASNExpr {
    ASNExpr var;
    ASNExpr postfix;
    //since postfix is definitely a terminal node, the information can be read directly into the member access node

    //if postfix is identifier or arrayAccess;
    String varName;
    List<ASNExpr> arrayIds;
    //if postfix is method
    String funcName;
    List<ASNExpr> parameters;

    public ASNMemberAccess(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public void build() {
        var = (ASNExpr) children.get(0);
        postfix = (ASNExpr) children.get(1);
    }

    @Override
    public void check() throws CompileException {
        var.check();
        if (var.returnType.dimension == 0) {
            ClassEntity entity = scopeBuffer.searchClass(var.returnType.baseType);
            if (entity == null) throw new InvalidExpression();
            scopeBuffer.push(new Scope(entity));
        } else scopeBuffer.push(new Scope(ClassEntity.arrayClass));
        postfix.check();
        scopeBuffer.pop();
        returnType = postfix.returnType;
        ifLeftValue = postfix.ifLeftValue;
        if (postfix instanceof ASNIdentifier) {
            varName = ((ASNIdentifier) postfix).identifier;
        } else if (postfix instanceof ASNArrayAccess) {
            varName = ((ASNArrayAccess) postfix).arrayIden;
            arrayIds = ((ASNArrayAccess) postfix).arrayIds;
        } else if (postfix instanceof ASNFuncCall) {
            funcName = ((ASNFuncCall) postfix).funcName;
            parameters = ((ASNFuncCall) postfix).parameters;
        } else throw new CompileException("Unexpected member access type");
    }

    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        var srcVar = var.irGeneration(irBuilder, irFunction);
        if (postfix instanceof ASNIdentifier) {
            var curStruct = irBuilder.structs.get(srcVar.type.tarStruct.structName);
            ++irFunction.localVarIndex;
            var returnVar = new IRVar(new IRType(returnType, irBuilder), irFunction.localVarIndex);
            var curIns = new IRGetPtr();
            curIns.structOffset=curStruct.getMemberOffset(varName);
            curIns.des = returnVar;
            curIns.src = srcVar;
            curIns.indexes.add(new IRVar(0, IRType.Genre.I32));
            curIns.indexes.add(new IRVar(curStruct.getMemberIndex(varName), IRType.Genre.I32));
            irFunction.addIns( curIns);
            if(ifLoad){
                var loadIns=new IRLoad();
                ++irFunction.localVarIndex;
                loadIns.des= new IRVar(returnVar.type.deref(), irFunction.localVarIndex);
                loadIns.src=srcVar;
                irFunction.addIns( loadIns);
                return loadIns.des;
            }
            return returnVar;
        } else if (postfix instanceof ASNArrayAccess) {
            var curStruct = irBuilder.structs.get(srcVar.type.tarStruct.structName);
            ++irFunction.localVarIndex;
            var returnVar = new IRVar(new IRType(returnType, irBuilder), irFunction.localVarIndex);
            var curIns = new IRGetPtr();
            curIns.des = returnVar;
            curIns.src = srcVar;
            curIns.structOffset=curStruct.getMemberOffset(varName);
            curIns.indexes.add(new IRVar(0, IRType.Genre.I32));
            curIns.indexes.add(new IRVar(curStruct.getMemberIndex(varName), IRType.Genre.I32));
            irFunction.addIns( curIns);
            for (var arrayId : arrayIds) {
                var getPtrIns = new IRGetPtr();
                getPtrIns.src = new IRVar(returnVar);
                returnVar = new IRVar(IRType.new_i32(), irFunction.localVarIndex);
                getPtrIns.indexes.add(arrayId.irGeneration(irBuilder, irFunction));
                getPtrIns.des = returnVar;
                ++irFunction.localVarIndex;
                returnVar = new IRVar(IRType.new_i32(), irFunction.localVarIndex);
                irFunction.addIns( getPtrIns);
            }
            if(ifLoad){
                var loadIns=new IRLoad();
                ++irFunction.localVarIndex;
                loadIns.des= new IRVar(returnVar.type.deref(), irFunction.localVarIndex);
                loadIns.src=srcVar;
                irFunction.addIns( loadIns);
                return loadIns.des;
            }
            return returnVar;
        } else if (postfix instanceof ASNFuncCall) {
            var curIns = new IRCall();
            ++irFunction.localVarIndex;
            curIns.returnVar = new IRVar(new IRType(returnType, irBuilder), irFunction.localVarIndex);
            if (funcName.equals("size") ) curIns.funcName = "__GET__SIZE";
            else if(funcName.equals("length")) curIns.funcName="__STRING_LENGTH";
            else if (funcName.equals("parseInt")) curIns.funcName = "__STRING_PARSE_INT";
            else if (funcName.equals("ord")) curIns.funcName = "__STRING_ORD";
            else if (funcName.equals("substring")) curIns.funcName = "__SUBSTRING";
            else curIns.funcName = funcName;
            curIns.paras.add(srcVar);
            for (var para : parameters) {
                curIns.paras.add(para.irGeneration(irBuilder, irFunction));
            }
            irFunction.addIns( curIns);
            return curIns.returnVar;
        }
        return null;
    }

}

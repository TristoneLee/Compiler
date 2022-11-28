package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRCall;
import IR.IRIns.IRGetPtr;
import IR.IRStruct;
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

    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        var srcVar=var.irGeneration(irBuilder,irFunction,curBlock);
        var curStruct=irBuilder.structs.get(srcVar.type.baseType);
        if(postfix instanceof ASNIdentifier) {
            ++irFunction.localVarIndex;
            var returnVar= new IRVar(returnType, irFunction.localVarIndex);
            var curIns = new IRGetPtr();
            curIns.des=returnVar;
            curIns.src=srcVar;
            curIns.num=new IRVar(curStruct.getMemberIndex(varName));
            irFunction.addIns(curBlock,curIns);
            return returnVar;
        }else if(postfix instanceof ASNArrayAccess){
            ++irFunction.localVarIndex;
            var returnVar= new IRVar(returnType, irFunction.localVarIndex);
            var curIns = new IRGetPtr();
            curIns.des=returnVar;
            curIns.src=srcVar;
            curIns.num=new IRVar(curStruct.getMemberIndex(varName));
            irFunction.addIns(curBlock,curIns);
            for (var arrayId:arrayIds){
                var getPtrIns = new IRGetPtr();
                getPtrIns.src=new IRVar(returnVar);
                returnVar=new IRVar(IntegerType,irFunction.localVarIndex);
                getPtrIns.num=arrayId.irGeneration(irBuilder,irFunction,curBlock);
                getPtrIns.des=returnVar;
                ++irFunction.localVarIndex;
                returnVar=new IRVar(IntegerType,irFunction.localVarIndex);
                irFunction.addIns(curBlock,getPtrIns);
            }
            return returnVar;
        }else if (postfix instanceof ASNFuncCall){
            var curIns=new IRCall();
            ++irFunction.localVarIndex;
            curIns.returnVar= new IRVar(returnType, irFunction.localVarIndex);
            curIns.funcName=funcName;
            curIns.paras.add(srcVar);
            for(var para:parameters){
                curIns.paras.add(para.irGeneration(irBuilder,irFunction,curBlock));
            }
            return curIns.returnVar;
        }
        return null;
    }

}

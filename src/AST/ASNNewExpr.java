package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.*;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ClassEntity;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.List;
import java.util.Objects;

public class ASNNewExpr extends ASNExpr {
    ASNNewTypeSpecifier newArray;
    ASNIdentifier newClass;

    public ASNNewExpr(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public void build() {
        if (children.get(0) instanceof ASNNewTypeSpecifier) newArray = (ASNNewTypeSpecifier) children.get(0);
        else newClass = (ASNIdentifier) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        if (newArray != null) {
            newArray.check();
            String _baseType = newArray.returnType.baseType;
            if (Objects.equals(_baseType, "string") || Objects.equals(_baseType, "int") || Objects.equals(_baseType, "bool"))
                returnType = newArray.returnType;
            else {
                ClassEntity entity = scopeBuffer.searchClass(newArray.returnType.baseType);
                if (entity == null) throw new CompileException("UndefinedClass");
                else returnType = newArray.returnType;
            }
        } else {
            ClassEntity classEntity = scopeBuffer.searchClass(newClass.identifier);
            if (classEntity == null) throw new CompileException("UndefinedClass");
            returnType = new ValueType(newClass.identifier);
        }
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        if (newClass != null) {
            var curStruct = irBuilder.searchStruct(newClass.identifier);
            ++irFunction.localVarIndex;
            var curVar = new IRVar(IRType.new_i8_ptr(), irFunction.localVarIndex);
            var callIns=new IRCall("__MALLOC");
            callIns.paras.add(new IRVar(curStruct.getStructSize(), IRType.Genre.I32));
            callIns.returnVar=curVar;
            irFunction.addIns(callIns);
            ++irFunction.localVarIndex;
            var castIns=new IRBitcast();
            castIns.srcVar=curVar;
            castIns.returnVar=new IRVar(new IRType(returnType,irBuilder), irFunction.localVarIndex);
            irFunction.addIns(castIns);
            curVar=castIns.returnVar;
            if (curStruct.Constructor != null) {
                var curIns = new IRCall();
                curIns.function = curStruct.Constructor;
                curIns.funcName= curIns.function.funcName;
                curIns.paras.add(curVar);
                irFunction.addIns( curIns);
            }else{
                var curIns= new IRAlloca(curVar);
                irFunction.addIns(curIns);
            }
            return curVar;
        } else {
            return arrayGeneration(irBuilder, irFunction, newArray.indexes);
        }
    }

    IRVar arrayGeneration(IRBuilder irBuilder, IRFunction irFunction, List<ASNExpr> indexes){
        var newType=new IRType(returnType,irBuilder);
        var varSize=new IRVar(newType.deref().getSize(), IRType.Genre.I32 );
        var arrayDim=indexes.size()- newArray.newDim;
        if(arrayDim ==1){
            var lengthVar= indexes.get(0).irGeneration(irBuilder,irFunction);
            var callIns=new IRCall("__MALLOC_ARRAY");
            ++irFunction.localVarIndex;
            callIns.returnVar=new IRVar(new IRType(returnType,irBuilder), irFunction.localVarIndex);
            callIns.paras.add(varSize);
            callIns.paras.add(lengthVar);
            irFunction.addIns(callIns);
            return callIns.returnVar;
        }else {
            ++irFunction.localVarIndex;
            var callIns1=new IRCall("__MALLOC_ARRAY");
            callIns1.returnVar=new IRVar(IRType.new_i32ptr(), irFunction.localVarIndex);
            callIns1.paras.add(new IRVar(4, IRType.Genre.I32));
            callIns1.paras.add(new IRVar(arrayDim, IRType.Genre.I32));
            irFunction.addIns(callIns1);
            var srcVar=callIns1.returnVar;
            for(int i=0;i<indexes.size();++i){
                if(indexes.get(i)==null) break;
                var getIndexIns=new IRGetPtr();
                getIndexIns.indexes.add(new IRVar(i, IRType.Genre.I32));
                getIndexIns.src=srcVar;
                ++irFunction.localVarIndex;
                var desVar=new IRVar(IRType.new_i32(), irFunction.localVarIndex);
                getIndexIns.des=desVar;
                irFunction.addIns(getIndexIns);
                var indexVar=indexes.get(i).irGeneration(irBuilder,irFunction);
                var storeIns=new IRStore(desVar,indexVar);
                irFunction.addIns(storeIns);
            }
            var callIns2=new IRCall("__MALLOC_ARRAY_MUL");
            ++irFunction.localVarIndex;
            callIns2.returnVar= new IRVar(IRType.new_i8_ptr(), irFunction.localVarIndex);
            callIns2.paras.add(varSize);
            callIns2.paras.add(new IRVar(arrayDim, IRType.Genre.I32));
            callIns2.paras.add(srcVar);
            irFunction.addIns(callIns2);
            var castIns=new IRBitcast();
            castIns.srcVar=callIns2.returnVar;
            castIns.desType=new IRType(returnType,irBuilder);
            ++irFunction.localVarIndex;
            castIns.returnVar=new IRVar(castIns.desType, irFunction.localVarIndex);
            irFunction.addIns(castIns);
            return castIns.returnVar;
        }
    }
}

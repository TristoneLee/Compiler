package AST;

import IR.IRBlock;
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
            }
            return curVar;
        } else {
            return arrayGeneration(irBuilder, irFunction,new IRType(new ValueType(newArray.baseType),irBuilder), newArray.dimension- newArray.newDim, newArray.indexes,0);
        }
    }

    IRVar arrayGeneration(IRBuilder irBuilder, IRFunction irFunction,IRType baseType,int dim, List<ASNExpr> indexes,int startIndex){
        var widthVar=new IRVar(baseType.getSize(), IRType.Genre.I32);
        var sizeVar = indexes.get(startIndex).irGeneration(irBuilder,irFunction);
        ++irFunction.localVarIndex;
        var lenVar=new IRVar(IRType.new_i32(), irFunction.localVarIndex);
        irFunction.addIns(new IRCalc(widthVar,sizeVar,lenVar, IRCalc.IROp.star));
        irFunction.addIns(new IRCalc(lenVar,new IRVar(4, IRType.Genre.I32),lenVar, IRCalc.IROp.plus));
        var callIns=new IRCall("__MALLOC");
        ++irFunction.localVarIndex;
        var mallocPtr=new IRVar(IRType.new_i8_ptr(), irFunction.localVarIndex);
        callIns.paras.add(lenVar);
        callIns.returnVar=mallocPtr;
        irFunction.addIns(callIns);
        ++irFunction.localVarIndex;
        var intPtr=new IRVar(IRType.new_i32ptr(), irFunction.localVarIndex);
        irFunction.addIns(new IRBitcast(intPtr,mallocPtr));
        irFunction.addIns(new IRStore(intPtr,sizeVar));
        irFunction.addIns(new IRCalc(intPtr,new IRVar(4, IRType.Genre.I32),intPtr, IRCalc.IROp.plus));
        ++irFunction.localVarIndex;
        var srcVar=new IRVar(new IRType(baseType), irFunction.localVarIndex);
        srcVar.type.dim+=dim+ newArray.newDim;
        irFunction.addIns(new IRBitcast(srcVar,intPtr));
        if(dim>1){
            IRBlock conditionBlock=new IRBlock();
            IRBlock bodyBlock=new IRBlock();
            IRBlock forwardBlock=new IRBlock();
            ++irFunction.localVarIndex;
            var iter=new IRVar(IRType.new_i32(), irFunction.localVarIndex);
            irFunction.addIns(new IRLoad(iter,new IRVar(0, IRType.Genre.I32)));
            irFunction.addIns(new IRBr(conditionBlock));
            irFunction.curBlock=conditionBlock;
            irFunction.blocks.add(conditionBlock);
            ++irFunction.localVarIndex;
            var condVar=new IRVar(IRType.new_i1(), irFunction.localVarIndex);
            irFunction.addIns(new IRCalc(iter,sizeVar,condVar, IRCalc.IROp.less));
            irFunction.addIns(new IRCondBr(condVar,bodyBlock,forwardBlock));
            irFunction.blocks.add(bodyBlock);
            irFunction.curBlock=bodyBlock;
            ++irFunction.localVarIndex;
            var ptrVar=new IRVar(new IRType(srcVar.type), irFunction.localVarIndex);
            ptrVar.type.dim--;
            var getPtrIns=new IRGetPtr();
            getPtrIns.src=srcVar;
            getPtrIns.des=ptrVar;
            getPtrIns.indexes.add(iter);
            irFunction.addIns(getPtrIns);
            irFunction.addIns(new IRStore(ptrVar,arrayGeneration(irBuilder,irFunction,baseType,dim-1,indexes,startIndex+1)));
            irFunction.addIns(new IRCalc(iter,new IRVar(1, IRType.Genre.I32),iter, IRCalc.IROp.plus));
            irFunction.addIns(new IRBr(conditionBlock));
            irFunction.curBlock=forwardBlock;
            irFunction.blocks.add(forwardBlock);
        }
        return srcVar;
    }
}

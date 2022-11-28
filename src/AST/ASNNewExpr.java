package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRAlloca;
import IR.IRIns.IRCall;
import IR.IRIns.IRGetPtr;
import IR.IRUtility.IRVar;
import parser.ClassEntity;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.time.temporal.ValueRange;
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
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        if (newClass != null) {
            var curStruct = irBuilder.searchStruct(newClass.identifier);
            ++irFunction.localVarIndex;
            var curVar = new IRVar(newClass.returnType, irFunction.localVarIndex, 1);
            var curIns = new IRCall();
            curIns.function = curStruct.Constructor;
            curIns.returnVar = curVar;
            irFunction.addIns(curBlock,curIns);
            return curVar;
        }else{
            return arrayGeneration(irBuilder,irFunction,curBlock,newArray.dimensions,new ValueType(newArray.baseType));
        }
    }

    IRVar arrayGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock, List<Integer> indexes, ValueType valueType){
        if(indexes.isEmpty()||indexes.get(0)==0) return null;
        ++irFunction.localVarIndex;
        var returnVar=new IRVar(valueType, irFunction.localVarIndex,indexes.size());
        returnVar.length=indexes.get(0);
        var allocIns=new IRAlloca(returnVar);
        irFunction.addIns(curBlock,allocIns);
        indexes=indexes.subList(1,indexes.size());
        for(int i=0;i<returnVar.length;++i){
            var uniVar=arrayGeneration(irBuilder,irFunction,curBlock,indexes,valueType);
            if(uniVar!=null){
                ++irFunction.localVarIndex;
                var desVar=new IRVar(valueType, irFunction.localVarIndex,indexes.size());
                var getPtrIns= new IRGetPtr();
                getPtrIns.num=new IRVar(i);
                getPtrIns.src=returnVar;
                getPtrIns.des=desVar;
                irFunction.addIns(curBlock,getPtrIns);
            }
        }
        return returnVar;
    }
}

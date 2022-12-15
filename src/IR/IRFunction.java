package IR;

import AST.ASNFuncDec;
import IR.IRIns.IRIns;
import IR.IRUtility.IRScopeStack;
import IR.IRUtility.IRVar;
import parser.ClassEntity;
import parser.FunctionEntity;
import utility.Parameter;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;

public class IRFunction {
    public String funcName;
    public List<IRVar> paras;
    public List<IRBlock> blocks;
    public Integer localVarIndex;

    public IRFunction(ASNFuncDec asnFuncDec) {
        localVarIndex=0;
        FunctionEntity entity = asnFuncDec.entity;
        paras = new ArrayList<>();
        funcName = entity.functionName;
        for (Parameter para : entity.paraList) paras.add(new IRVar(para.valueType,localVarIndex++));
    }

    static public List<IRFunction> methodsExtract(ClassEntity classEntity) {
        List<IRFunction> funcs = new ArrayList<>();
        classEntity.classMethod.forEach(((s, entity) -> entity.paraList.add(new Parameter("this", new ValueType(classEntity.className)))));
        return funcs;
    }

    public void addIns(int blockId, IRIns ins){
        blocks.get(blockId).add(ins);
    }

    public void setContinueBlock(int blockIndex,int continueBlock_){
        blocks.get(blockIndex).continueBlock=continueBlock_;
    }

    public void setBreakBlock (int blockIndex,int breakBlock_){
        blocks.get(blockIndex).breakBlock=breakBlock_;
    }
}

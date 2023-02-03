package IR;

import AST.ASNClassConstructorDec;
import AST.ASNFuncDec;
import IR.IRIns.IRCall;
import IR.IRIns.IRIns;
import IR.IRIns.IRRet;
import IR.IRIns.IRStore;
import IR.IRUtility.IRScopeStack;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ClassEntity;
import parser.FunctionEntity;
import utility.Parameter;
import utility.ValueType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class IRFunction {
    public String funcName;
    public List<IRVar> paras = new ArrayList<>();
    public Integer localVarIndex = 0;
    public List<IRBlock> blocks = new ArrayList<>();
    FunctionEntity asnEntity;
    ASNFuncDec asnFuncDec;
    public IRBlock curBlock;
    public boolean ifMethod;
    public boolean ifConstructor;
    public IRStruct struct;
    public IRBlock breakBlock;
    public IRBlock continueBlock;

    public IRFunction() {
    }

    public IRFunction(IRBuilder irBuilder, ASNFuncDec asnFuncDec_) {
        ifMethod = false;
        asnFuncDec = asnFuncDec_;
        localVarIndex = -1;
        asnEntity = asnFuncDec.entity;
        paras = new ArrayList<>();
        funcName = asnEntity.functionName;
    }

    public IRFunction(IRBuilder irBuilder, ASNFuncDec asnFuncDec_, IRStruct struct_) {
        ifMethod = true;
        struct = struct_;
        asnFuncDec = asnFuncDec_;
        if(asnFuncDec_ instanceof ASNClassConstructorDec) ifConstructor=true;
        localVarIndex = -1;
        paras = new ArrayList<>();
        funcName = struct.structName + "_" + asnFuncDec.entity.functionName;
//        if(funcName.equals("main")){
//            blocks.get(blocks.size()-1).insList.add(new IRRet())
//        }
    }

    public void functionBuild(IRBuilder irBuilder) {
        irBuilder.irScopeStack.push();
        curBlock=new IRBlock();
        blocks.add(curBlock);
        if (funcName.equals("main")) {
            addIns( new IRCall("__INIT"));
        }
        if (ifMethod) {
            irBuilder.irScopeStack.push();
            var thisVar = new IRVar(new IRType(new ValueType(struct.structName), irBuilder), ++localVarIndex);
            paras.add(thisVar);
            for (Parameter para : asnFuncDec.entity.paraList) {
                var tmpVar = new IRVar(new IRType(para.valueType, irBuilder), ++localVarIndex);
                paras.add(tmpVar);
                irBuilder.irScopeStack.peek().put(para.name, tmpVar);
            }
        } else if (asnEntity != null) for (Parameter para : asnEntity.paraList) {
            var tmpVar = new IRVar(new IRType(para.valueType, irBuilder), ++localVarIndex);
            paras.add(tmpVar);
            irBuilder.irScopeStack.peek().put(para.name, tmpVar);
        }
        asnFuncDec.funcBody.irGeneration(irBuilder, this);
        for(int i=0;i<blocks.size();++i){
            blocks.get(i).index=i;
        }
        var lastBlock=blocks.get(blocks.size()-1).insList;
        if(ifConstructor) {
            if(! (lastBlock.get(lastBlock.size()-1) instanceof IRRet)) lastBlock.add(new IRRet());
        }
        else if(funcName.equals("main")) {
            if(! (lastBlock.get(lastBlock.size()-1) instanceof IRRet)) lastBlock.add(new IRRet(new IRVar(0, IRType.Genre.I32)));
        }
    }


    static public List<IRFunction> methodsExtract(ClassEntity classEntity) {
        List<IRFunction> funcs = new ArrayList<>();
        classEntity.classMethod.forEach(((s, entity) -> entity.paraList.add(new Parameter("this", new ValueType(classEntity.className)))));
        return funcs;
    }

    public void addIns( IRIns ins) {
        curBlock.add(ins);
    }

    public void setContinueBlock( IRBlock continueBlock_) {
        continueBlock = continueBlock_;
    }

    public void setBreakBlock( IRBlock breakBlock_) {
        breakBlock = breakBlock_;
    }

    public void print() {
        System.out.print(funcName + "(");
        for (int i = 0; i < paras.size(); ++i) {
            System.out.print(paras.get(i));
            if (i != paras.size() - 1) System.out.print(", ");
        }
        System.out.print("){\n");
        Integer i = 0;
        for (var blocK : blocks) {
            System.out.print(i.toString() + ":\n");
            i++;
            blocK.print();
        }
        System.out.print("}\n");
    }

}

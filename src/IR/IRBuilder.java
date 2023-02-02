package IR;

import AST.*;
import IR.IRIns.IRAlloca;
import IR.IRIns.IRIns;
import IR.IRIns.IRRet;
import IR.IRIns.IRStore;
import IR.IRUtility.IRScopeStack;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ASTbuilder;
import parser.ScopeBuffer;

import java.util.*;

public class IRBuilder {
    public Map<String,IRFunction> funcs=new LinkedHashMap<>();
    public Map<String,IRStruct> structs=new LinkedHashMap<>();
    public IRScopeStack irScopeStack=new IRScopeStack();
    public Map<String,IRVar> globVars=new LinkedHashMap<>();
    public Integer constStringCount=0;
    public Map<String,IRVar> constStringMap=new LinkedHashMap<>();
    public IRFunction globalInit;


    public IRBuilder(ASTbuilder AST) {
        globalInit=new IRFunction();
        globalInit.funcName="__INIT";
        globalInit.blocks.add(new IRBlock());
        for(ASNVarDec asnVarDec:AST.varDecList){
            asnVarDec.globalInitGeneration(this,globalInit);
        }
        for (ASNClassDel asnClassDel:AST.classDelList){
            structs.put(asnClassDel.classEntity.className,new IRStruct(this,asnClassDel.classEntity));
        }
        for(ASNFuncDec asnFunc:AST.funcDecList){
            funcs.put(asnFunc.entity.functionName,new IRFunction(this,asnFunc));
        }
        for (var struct:structs.values()) struct.structBuild(this);
        for(var func:funcs.values()) func.functionBuild(this);
        globalInit.addIns(0,new IRRet());
        funcs.put("__INIT",globalInit);
    }

    public IRVar getConstString(String srcString){
        if(constStringMap.containsKey(srcString)){
            return constStringMap.get(srcString);
        }else {
            IRVar newVar=new IRVar(IRType.new_i8_ptr(),srcString);
            constStringMap.put(srcString,newVar);
            return newVar;
        }
    }

    public IRFunction searchFunction(String funcName){
        return funcs.get(funcName);
    }

    public IRStruct searchStruct(String structName){
        return structs.get(structName);
    }

    public void print(){
        structs.forEach((s,struct)->{
            struct.print();
        });
        funcs.forEach((s,func)->{
            func.print();
        });
    }

    public void stringInit(IRFunction initFunction){

    }
}

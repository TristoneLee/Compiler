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
    public LinkedList<IRVar> globVars=new LinkedList<>();
    public Integer constStringCount=-1;
    public Map<String,IRVar> constStringMap=new LinkedHashMap<>();
    public IRFunction globalInit;


    public IRBuilder(ASTbuilder AST) {
        globalInit=new IRFunction();
        globalInit.funcName="__INIT";
        globalInit.curBlock=new IRBlock();
        globalInit.blocks.add(globalInit.curBlock);
        for (ASNClassDel asnClassDel:AST.classDelList){
            structs.put(asnClassDel.classEntity.className,new IRStruct(this,asnClassDel.classEntity));
        }
        for(ASNFuncDec asnFunc:AST.funcDecList){
            funcs.put(asnFunc.entity.functionName,new IRFunction(this,asnFunc));
        }
        for (var struct:structs.values()) struct.structBuild(this);
        for(ASNVarDec asnVarDec:AST.varDecList){
            asnVarDec.globalInitGeneration(this,globalInit);
        }
        globalInit.addIns(new IRRet());
        for(var func:funcs.values()) func.functionBuild(this);
        funcs.put("__INIT",globalInit);

    }

    public IRVar getConstString(String srcString){
        ++constStringCount;
        if(constStringMap.containsKey(srcString)){
            return constStringMap.get(srcString);
        }else {
            IRVar newVar=new IRVar(IRType.new_i8_ptr(),"str"+constStringCount);
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

}

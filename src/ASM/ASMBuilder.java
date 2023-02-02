package ASM;

import ASM.ASMutility.ASMVar;
import IR.IRBuilder;
import IR.IRUtility.IRVar;

import java.util.LinkedList;

public class ASMBuilder {
    LinkedList<ASMFunction> funcs;
    LinkedList<ASMVar> globVars;
    LinkedList<IRVar> strConsts;
    int stackOffset;

    public ASMBuilder(IRBuilder ir){
        var irFuncs=ir.funcs;
        var irStructs=ir.structs;
        var irGlobVars=ir.globVars;
        irFuncs.forEach((name,func)->{
            funcs.add(new ASMFunction(func));
        });
    }

}

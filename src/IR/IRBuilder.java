package IR;

import AST.ASN;
import AST.ASNClassDel;
import AST.ASNFuncDec;
import AST.ASNVarDec;
import IR.IRUtility.IRScopeStack;
import IR.IRUtility.IRVar;
import parser.ASTbuilder;
import parser.ScopeBuffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IRBuilder {
    public Map<String,IRFunction> funcs;
    public Map<String,IRStruct> structs;
    public IRScopeStack irScopeStack;
    public Map<String,IRVar> globVars;
    public List<ASNVarDec> varDecStmts;

    public IRBuilder(ASTbuilder AST) {
        funcs=new HashMap<>();
        structs=new HashMap<>();
        irScopeStack=new IRScopeStack();
        globVars=new HashMap<>();
        varDecStmts = new ArrayList<>();
        ScopeBuffer scopeBuffer = AST.scopeBuffer;

        for (ASN child : AST.root.children) {
            if (child instanceof ASNFuncDec)
                scopeBuffer.functionTable.forEach((s, entity) -> funcs.put(((ASNFuncDec) child).entity.functionName,new IRFunction((ASNFuncDec) child)));
            else if (child instanceof ASNClassDel) scopeBuffer.classTable.forEach((s, entity) -> {
                structs.put(((ASNClassDel) child).classEntity.className,new IRStruct(((ASNClassDel) child).classEntity));
            });
            else if (child instanceof ASNVarDec) {
                varDecStmts.add((ASNVarDec) child);
            }
        }
    }

    public IRFunction searchFunction(String funcName){
        return funcs.get(funcName);
    }

    public IRStruct searchStruct(String structName){
        return structs.get(structName);
    }
}

package IR;

import AST.ASN;
import AST.ASNClassDel;
import AST.ASNFuncDec;
import AST.ASNVarDec;
import IR.IRUtility.IRGlobVar;
import parser.ASTbuilder;
import parser.ClassEntity;
import parser.ScopeBuffer;
import utility.Parameter;

import java.util.ArrayList;
import java.util.List;

public class IRBuilder {
    List<IRFuncScope> funcs;
    List<IRStruct> structs;
    List<IRGlobVar> globVars;
    List<ASNVarDec> varDecStmts;

    public IRBuilder(ASTbuilder AST) {
        funcs = new ArrayList<>();
        structs = new ArrayList<>();
        globVars = new ArrayList<>();
        varDecStmts = new ArrayList<>();
        ScopeBuffer scopeBuffer = AST.scopeBuffer;

        for (ASN child : AST.root.children) {
            if (child instanceof ASNFuncDec)
                scopeBuffer.functionTable.forEach((s, entity) -> funcs.add(new IRFuncScope((ASNFuncDec) child)));
            else if (child instanceof ASNClassDel) scopeBuffer.classTable.forEach((s, entity) -> {
                structs.add(new IRStruct(((ASNClassDel) child).classEntity));
                funcs.addAll(IRFuncScope.methodsExtract(((ASNClassDel) child).classEntity));
            });
            else if (child instanceof ASNVarDec) {
                varDecStmts.add((ASNVarDec) child);
            }
        }
    }
}

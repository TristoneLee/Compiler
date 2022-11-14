package IR;

import AST.ASNFuncDec;
import IR.IRUtility.IRFuncBody;
import IR.IRUtility.IRVar;
import parser.ClassEntity;
import parser.FunctionEntity;
import utility.Parameter;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;

public class IRFuncScope {
    String funcName;
    List<IRVar> paras;
    IRFuncBody funcBody;

    public IRFuncScope(ASNFuncDec asnFuncDec) {
        FunctionEntity entity = asnFuncDec.entity;
        paras = new ArrayList<>();
        funcName = entity.functionName;
        for (Parameter para : entity.paraList) paras.add(new IRVar(para));
    }

    static public List<IRFuncScope> methodsExtract(ClassEntity classEntity) {
        List<IRFuncScope> funcs = new ArrayList<>();
        classEntity.classMethod.forEach(((s, entity) -> entity.paraList.add(new Parameter("this", new ValueType(classEntity.className)))));
        return funcs;
    }
}

package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRCall;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ClassEntity;
import parser.FunctionEntity;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;
import utility.Exception.UndeifinedVariety;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static utility.ValueType.VoidType;

public class ASNFuncCall extends ASNExpr {
    String funcName;
    List<ASNExpr> parameters;
    FunctionEntity entity;

    public ASNFuncCall(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
        parameters = new ArrayList<>();
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNStringConst && funcName == null) funcName = ((ASNStringConst) child).value;
            else if (child instanceof ASNExpr) parameters.add((ASNExpr) child);
            else throw new InvalidExpression();
        }
    }

    @Override
    public void check() throws CompileException {
        for (ASNExpr expr : parameters) expr.check();
        entity = scopeBuffer.searchFunc(funcName);
        if (entity == null) throw new CompileException("UndefinedFunction");
        if (entity.paraList.size() != parameters.size()) throw new CompileException("UndefinedFunction");
        for (int i = 0; i < parameters.size(); ++i) {
            if (!entity.paraList.get(i).valueType.equals(parameters.get(i).returnType) && !((entity.paraList.get(i).valueType.dimension != 0 || !entity.paraList.get(i).valueType.isBasicType()) && parameters.get(i).returnType.equals(ValueType.NullType)))
                throw new CompileException("UnmatchedParameter");
        }
        returnType = entity.returnType;
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        var curIns = new IRCall();
        for (var para : parameters) {
            curIns.paras.add(para.irGeneration(irBuilder, irFunction));
        }
        if (entity.returnType.equals(VoidType)) {
            curIns.returnVar = null;
        } else {
            ++irFunction.localVarIndex;
            curIns.returnVar = new IRVar(new IRType(returnType,irBuilder), irFunction.localVarIndex);
        }
        curIns.funcName = entity.functionName;
        curIns.function = irBuilder.searchFunction(funcName);
        irFunction.addIns(curIns);
        return curIns.returnVar;
    }
}

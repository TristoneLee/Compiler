package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRCalc;
import IR.IRIns.IRIns;
import IR.IRIns.IRLoad;
import IR.IRIns.IRStore;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;

import static utility.ValueType.IntegerType;

public class ASNPostfixExpr extends ASNExpr {
    public enum PostfixType {plusplus, minusminus}

    PostfixType type;
    ASNExpr expr;

    public ASNPostfixExpr(ScopeBuffer scopeBuffer, PostfixType _type) {
        super(scopeBuffer);
        type = _type;
    }


    @Override
    public void build() throws CompileException {
        expr = (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        expr.check();
        if (!expr.returnType.equals(IntegerType)) throw new InvalidExpression();
        if (!expr.ifLeftValue) throw new InvalidExpression();
        returnType = IntegerType;
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        expr.ifLoad = false;
        var lVar = expr.irGeneration(irBuilder, irFunction);
        var loadIns = new IRLoad();
        ++irFunction.localVarIndex;
        var valueVar = new IRVar(new IRType(returnType, irBuilder), irFunction.localVarIndex);
        loadIns.des = valueVar;
        loadIns.src = lVar;
        irFunction.addIns(loadIns);
        ++irFunction.localVarIndex;
        var returnVar = new IRVar(new IRType(returnType, irBuilder), irFunction.localVarIndex);
        var copyIns = new IRCalc(valueVar, new IRVar(0, IRType.Genre.I32), returnVar, IRCalc.IROp.plus);
        IRIns opIns;
        if (type == PostfixType.plusplus)
            opIns = new IRCalc(valueVar, new IRVar(1, IRType.Genre.I32), valueVar, IRCalc.IROp.plus);
        else opIns = new IRCalc(valueVar, new IRVar(1, IRType.Genre.I32), valueVar, IRCalc.IROp.minus);
        irFunction.addIns( copyIns);
        irFunction.addIns( opIns);
        var storeIns = new IRStore(lVar, valueVar);
        irFunction.addIns( storeIns);
        return returnVar;
    }
}

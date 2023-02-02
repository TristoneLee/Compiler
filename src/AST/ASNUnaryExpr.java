package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRCalc;
import IR.IRIns.IRLoad;
import IR.IRIns.IRStore;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;

import java.util.List;
import java.util.Stack;

import static utility.ValueType.BooleanType;
import static utility.ValueType.IntegerType;

public class ASNUnaryExpr extends ASNExpr {
    public enum UnaryOp {plusplus, minusminus, plus, minus, not, tilde}

    UnaryOp unaryOp;
    ASNExpr expr;

    public ASNUnaryExpr(ScopeBuffer scopeBuffer, UnaryOp op) {
        super(scopeBuffer);
        unaryOp = op;
    }

    @Override
    public void build() throws CompileException {
        expr = (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        expr.check();
        if (unaryOp == UnaryOp.not) {
            if (!expr.returnType.equals(BooleanType)) throw new InvalidExpression();
        } else if (!expr.returnType.equals(IntegerType)) throw new InvalidExpression();
        if ((unaryOp == UnaryOp.plusplus || unaryOp == UnaryOp.minusminus) && !expr.ifLeftValue)
            throw new InvalidExpression();
        returnType = expr.returnType;
        if (unaryOp == UnaryOp.plusplus || unaryOp == UnaryOp.minusminus) ifLeftValue = true;
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        if (unaryOp == UnaryOp.plusplus || unaryOp == UnaryOp.minusminus) {
            expr.ifLoad = false;
            var srcVar = expr.irGeneration(irBuilder, irFunction);
            ++irFunction.localVarIndex;
            var valueVar = new IRVar(IRType.new_i32(), irFunction.localVarIndex);
            var loadIns = new IRLoad();
            loadIns.src = srcVar;
            loadIns.des = valueVar;
            var calcIns = new IRCalc(valueVar, new IRVar(1, IRType.Genre.I32), valueVar, unaryOp == UnaryOp.plusplus ? IRCalc.IROp.plus : IRCalc.IROp.minus);
            var storeIns = new IRStore();
            storeIns.src = valueVar;
            storeIns.des = srcVar;
            irFunction.addIns(irFunction.curBlock, loadIns);
            irFunction.addIns(irFunction.curBlock, calcIns);
            irFunction.addIns(irFunction.curBlock, storeIns);
            if (ifLoad)
                return valueVar;
            else return srcVar;
        }
        var rVar = expr.irGeneration(irBuilder, irFunction);
        if (unaryOp == UnaryOp.plusplus) return rVar;
        ++irFunction.localVarIndex;
        var returnVar = new IRVar(new IRType(returnType, irBuilder), irFunction.localVarIndex);
        if (unaryOp == UnaryOp.not) {
            var curIns = new IRCalc(new IRVar(1, IRType.Genre.I32), rVar, returnVar, IRCalc.IROp.exclusiveOr);
            irFunction.addIns(irFunction.curBlock, curIns);
        } else if (unaryOp == UnaryOp.minus) {
            var curIns = new IRCalc(new IRVar(0, IRType.Genre.I32), rVar, returnVar, IRCalc.IROp.minus);
            irFunction.addIns(irFunction.curBlock, curIns);
        } else if (unaryOp == UnaryOp.tilde) {
            var curIns = new IRCalc(new IRVar(-1, IRType.Genre.I32), rVar, returnVar, IRCalc.IROp.exclusiveOr);
            irFunction.addIns(irFunction.curBlock, curIns);
        }
        return returnVar;
    }
}

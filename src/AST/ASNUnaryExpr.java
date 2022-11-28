package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRCalc;
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
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        var rVar = expr.irGeneration(irBuilder, irFunction, curBlock);
        if(unaryOp==UnaryOp.plusplus) return rVar;
        ++irFunction.localVarIndex;
        var returnVar = new IRVar(returnType, irFunction.localVarIndex);
        if (unaryOp == UnaryOp.not) {
            var curIns = new IRCalc(new IRVar(1), rVar, returnVar, IRCalc.IROp.exclusiveOr);
            irFunction.addIns(curBlock, curIns);
        } else if (unaryOp == UnaryOp.minus) {
            var curIns = new IRCalc(new IRVar(0), rVar, returnVar, IRCalc.IROp.minus);
            irFunction.addIns(curBlock, curIns);
        } else if (unaryOp == UnaryOp.tilde) {
            var curIns = new IRCalc(new IRVar(-1), rVar, returnVar, IRCalc.IROp.exclusiveOr);
            irFunction.addIns(curBlock, curIns);
        } else if (unaryOp == UnaryOp.plusplus) {
            var curIns = new IRCalc(new IRVar(1), rVar, returnVar, IRCalc.IROp.plus);
            irFunction.addIns(curBlock, curIns);
        } else if (unaryOp == UnaryOp.minusminus) {
            var curIns = new IRCalc(new IRVar(-1), rVar, returnVar, IRCalc.IROp.plus);
            irFunction.addIns(curBlock, curIns);
        }
        return returnVar;
    }
}

package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRCalc;
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
        super( scopeBuffer);
        type = _type;
    }


    @Override
    public void build() throws CompileException {
        expr= (ASNExpr) children.get(0);
    }

    @Override
    public void check() throws CompileException {
        expr.check();
        if(!expr.returnType.equals(IntegerType) ) throw new InvalidExpression();
        if(!expr.ifLeftValue) throw new InvalidExpression();
        returnType=IntegerType;
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        var lVar= expr.irGeneration(irBuilder,irFunction,curBlock);
        ++irFunction.localVarIndex;
        var returnVar = new IRVar(returnType, irFunction.localVarIndex);
        var copyIns=new IRCalc(new IRVar(0),lVar,returnVar, IRCalc.IROp.plus);
        var opIns=new IRCalc(new IRVar(1),lVar,lVar, IRCalc.IROp.plus);
        irFunction.addIns(curBlock,opIns);
        irFunction.addIns(curBlock,copyIns);
        return returnVar;
    }
}

package AST;

import IR.IRBlock;
import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.*;
import IR.IRUtility.IRType;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;

import static utility.ValueType.*;

public class ASNBinaryExpr extends ASNExpr {
    // 1:lhs 2:rhs
    public enum Operate {
        plus, minus, star, div, mod, less, lessEqual, greaterEqual, greater, leftShift,
        rightShift, and, or, logicalAnd, logicalOr, equal, notEqual, assign, exclusiveOr
    }

    public ASNExpr lhs, rhs;
    IRBlock formerIndex;
    IRBlock rhsIndex;
    IRBlock endIndex;

    Operate op;

    public ASNBinaryExpr(Operate op_, ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
        op = op_;
    }

    @Override
    public void build() throws CompileException {
        lhs = (ASNExpr) children.get(0);
        rhs = (ASNExpr) children.get(1);
    }

    @Override
    public void check() throws CompileException {
        lhs.check();
        rhs.check();
        switch (op) {
            case plus -> {
                if (rhs.returnType.equals(StringType) && lhs.returnType.equals(StringType)) returnType = StringType;
                else if (rhs.returnType.equals(IntegerType) && lhs.returnType.equals(IntegerType))
                    returnType = IntegerType;
                else throw new InvalidExpression();
            }
            case minus, star, div, mod, leftShift, rightShift, and, or, exclusiveOr -> {
                if (rhs.returnType.equals(IntegerType) && lhs.returnType.equals(IntegerType)) returnType = IntegerType;
                else throw new InvalidExpression();
            }
            case less, greater, lessEqual, greaterEqual -> {
                if (rhs.returnType.equals(StringType) && lhs.returnType.equals(StringType)) returnType = BooleanType;
                else if (rhs.returnType.equals(IntegerType) && lhs.returnType.equals(IntegerType))
                    returnType = BooleanType;
                else throw new InvalidExpression();
            }
            case logicalAnd, logicalOr -> {
                if (rhs.returnType.equals(BooleanType) && lhs.returnType.equals(BooleanType)) returnType = BooleanType;
                else throw new InvalidExpression();
            }
            case equal, notEqual -> {
                if (rhs.returnType.equals(lhs.returnType) || rhs.returnType.dimension != 0 && lhs.returnType.equals(NullType) || !rhs.returnType.isBasicType() && rhs.returnType.equals(NullType))
                    returnType = BooleanType;
                else throw new InvalidExpression();
            }
            case assign -> {
                if (lhs instanceof ASNIntConst || lhs instanceof ASNStringConst || lhs instanceof ASNBooleanConst || lhs instanceof ASNThis)
                    throw new InvalidExpression();
                if (!lhs.ifLeftValue) throw new InvalidExpression();
                else if (rhs.returnType.equals(lhs.returnType) || (lhs.returnType.dimension != 0 && rhs.returnType.equals(NullType)) || !lhs.returnType.isBasicType() && rhs.returnType.equals(NullType))
                    returnType = VoidType;
                else throw new InvalidExpression();
            }
        }
    }


    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        if (returnType != StringType) {
            if (op == Operate.assign) {
                lhs.ifLoad = false;
                var rhsVar = rhs.irGeneration(irBuilder, irFunction);
                var lhsVar = lhs.irGeneration(irBuilder, irFunction);
//                if (lhs instanceof ASNIdentifier) {
//                    var oldVar = irBuilder.irScopeStack.searchVar(((ASNIdentifier) lhs).identifier);
//                var newVar=new IRVar(oldVar);
//                newVar.index= ++irFunction.localVarIndex;
//                var curIns=new IRStore(newVar,rhsVar);
//                    var curIns = new IRStore(oldVar, rhsVar);
//                    irFunction.addIns(curBlock, curIns);
//                    return null;
//                }
                var curIns = new IRStore(lhsVar, rhsVar);
                irFunction.addIns(curIns);
                return null;
            }
            if (op == Operate.logicalOr || op == Operate.logicalAnd) {
                rhsIndex = new IRBlock();
                endIndex = new IRBlock();
                formerIndex= irFunction.curBlock;
                var ifAnd = op == Operate.logicalAnd;
                var lvar = lhs.irGeneration(irBuilder, irFunction);
                if (ifAnd) {
                    irFunction.addIns( new IRCondBr(lvar, rhsIndex, endIndex));
                } else irFunction.addIns( new IRCondBr(lvar, endIndex, rhsIndex));
                irFunction.curBlock=rhsIndex;
                irFunction.blocks.add(rhsIndex);
                var rvar=rhs.irGeneration(irBuilder,irFunction);
                irFunction.addIns(new IRBr(endIndex));
                irFunction.curBlock=endIndex;
                irFunction.blocks.add(endIndex);
                ++irFunction.localVarIndex;
                var returnVar=new IRVar(IRType.new_i1(), irFunction.localVarIndex);
                if(ifAnd)
                    irFunction.addIns(new IRPhi(returnVar,formerIndex,new IRVar(0, IRType.Genre.I1),rhsIndex,rvar));
                else irFunction.addIns(new IRPhi(returnVar,formerIndex,new IRVar(1, IRType.Genre.I1),rhsIndex,rvar));
                return returnVar;
            }
            var rhsVar = rhs.irGeneration(irBuilder, irFunction);
            var lhsVar = lhs.irGeneration(irBuilder, irFunction);
            irFunction.localVarIndex++;
            IRVar returnVar;
            if (returnType.equals(IntegerType)) returnVar = new IRVar(IRType.new_i32(), irFunction.localVarIndex);
            else returnVar = new IRVar(IRType.new_i1(), irFunction.localVarIndex);
            irFunction.addIns( new IRCalc(lhsVar, rhsVar, returnVar, IRCalc.IROp.valueOf(op.name())));
            return returnVar;
        } else {
            var callIns = new IRCall();
            ++irFunction.localVarIndex;
            var returnvar = new IRVar(op == Operate.plus ? IRType.new_i8_ptr() : IRType.new_i1(), irFunction.localVarIndex);
            callIns.ifInBuild = true;
            switch (op) {
                case plus -> callIns.funcName = "__STRING_ADD";
                case equal -> callIns.funcName = "__STRING_EQUAL";
                case notEqual -> callIns.funcName = "STRING_NOT_EQUAL";
                case less -> callIns.funcName = "__STRING_LESS";
                case greater -> callIns.funcName = "__STRING_GREATER";
                case lessEqual -> callIns.funcName = "__STRING_LESS_EQUAL";
                case greaterEqual -> callIns.funcName = "__STRING_GREATER_EQUAL";
            }
            var rhsVar = rhs.irGeneration(irBuilder, irFunction);
            var lhsVar = rhs.irGeneration(irBuilder, irFunction);
            callIns.returnVar = returnvar;
            callIns.paras.add(lhsVar);
            callIns.paras.add(rhsVar);
            irFunction.addIns( callIns);
            return returnvar;
        }
    }
}

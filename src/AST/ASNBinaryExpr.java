package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRCalc;
import IR.IRIns.IRStore;
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
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction,Integer curBlock) {
        if (op == Operate.assign) {
            var rhsVar=rhs.irGeneration(irBuilder,irFunction,curBlock);
            if(lhs instanceof  ASNIdentifier){
                var oldVar = irBuilder.irScopeStack.searchVar(((ASNIdentifier) lhs).identifier);
                var newVar=new IRVar(oldVar);
                newVar.index= ++irFunction.localVarIndex;
                var curIns=new IRStore(newVar,rhsVar);
                irFunction.addIns(curBlock,curIns);
                return null;
            }
            var lhsVar=lhs.irGeneration(irBuilder,irFunction,curBlock);
            var curIns=new IRStore(lhsVar,rhsVar);
            irFunction.addIns(curBlock,curIns);
            return null;
        }
        var rhsVar = rhs.irGeneration(irBuilder,irFunction, curBlock);
        var lhsVar = lhs.irGeneration(irBuilder,irFunction, curBlock);
        irFunction.localVarIndex++;
        var returnVar = new IRVar(IntegerType, irFunction.localVarIndex);
        irFunction.blocks.get(curBlock).add(new IRCalc(lhsVar, rhsVar, returnVar,IRCalc.IROp.valueOf(op.name())));
        return returnVar;
    }
}

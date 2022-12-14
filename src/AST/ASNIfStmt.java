package AST;

import IR.IRBlock;
import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRBr;
import IR.IRIns.IRCondBr;
import IR.IRUtility.IRVar;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidStmt;

import static utility.ValueType.BooleanType;

public class ASNIfStmt extends ASNStmt {
    ASNExpr ifCondition;
    ASNIfBranch trueStmt;
    ASNIfBranch falseStmt;

    public ASNIfStmt(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public void build() {
        for (ASN child : children) {
            if (child instanceof ASNIfBranch) {
                if (((ASNIfBranch) child).dir) trueStmt = (ASNIfBranch) child;
                else falseStmt = (ASNIfBranch) child;
            } else if (child instanceof ASNExpr) {
                ifCondition = (ASNExpr) child;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        ifCondition.check();
        if (trueStmt != null) trueStmt.check();
        if (falseStmt != null) falseStmt.check();
        if (!ifCondition.returnType.equals(BooleanType)) throw new InvalidStmt();
    }

    int formerIndex;
    int conditionIndex;
    int trueStmtIndex;
    int falseStmtIndex;
    int forwardIndex;

    @Override
    public void controlFlowAnalysis(IRFunction irFunction) {
        var blocks = irFunction.blocks;
        formerIndex = blocks.size() - 1;
        conditionIndex = formerIndex + 1;
        blocks.add(new IRBlock());
        if (trueStmt != null) {
            blocks.add(new IRBlock());
            trueStmtIndex = blocks.size() - 1;
        }
        if (falseStmt != null) {
            blocks.add(new IRBlock());
            falseStmtIndex = blocks.size() - 1;
        }
        blocks.add(new IRBlock());
        forwardIndex = blocks.size() - 1;
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction, Integer curBlock) {
        if (ifCondition != null) {
            var condVar = ifCondition.irGeneration(irBuilder, irFunction, conditionIndex);
            if (falseStmt != null)
                irFunction.addIns(conditionIndex, new IRCondBr(condVar, trueStmtIndex, falseStmtIndex));
            else irFunction.addIns(conditionIndex, new IRCondBr(condVar, trueStmtIndex, forwardIndex));

        }
        if (trueStmt != null) {
            trueStmt.irGeneration(irBuilder, irFunction, trueStmtIndex);
            irFunction.addIns(trueStmtIndex, new IRBr(forwardIndex));
        }
        if (falseStmt != null) {
            falseStmt.irGeneration(irBuilder, irFunction, falseStmtIndex);
            irFunction.addIns(falseStmtIndex, new IRBr(forwardIndex));
        }
        curBlock = forwardIndex;
        return null;
    }
}

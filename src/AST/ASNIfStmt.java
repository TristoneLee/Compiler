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


    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        var trueBlock = new IRBlock();
        var falseBlock = new IRBlock();
        var forwardBlock = new IRBlock();
        if (ifCondition != null) {
            var condVar = ifCondition.irGeneration(irBuilder, irFunction);
            if (falseStmt != null)
                irFunction.addIns(new IRCondBr(condVar, trueBlock, falseBlock));
            else irFunction.addIns(new IRCondBr(condVar, trueBlock, forwardBlock));

        }
        irFunction.blocks.add(trueBlock);
        irFunction.curBlock = trueBlock;
        trueStmt.irGeneration(irBuilder, irFunction);
        irFunction.addIns(new IRBr(forwardBlock));
        if (falseStmt != null) {
            irFunction.curBlock = falseBlock;
            irFunction.blocks.add(falseBlock);
            falseStmt.irGeneration(irBuilder, irFunction);
            irFunction.addIns(new IRBr(forwardBlock));
        }
        irFunction.curBlock = forwardBlock;
        irFunction.blocks.add(forwardBlock);
        return null;
    }
}

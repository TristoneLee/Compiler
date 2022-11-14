package AST;

import IR.IRBlock;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidStmt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static utility.ValueType.BooleanType;

public class ASNIfStmt extends ASNStmt{
    ASNExpr ifCondition;
    ASNIfBranch trueStmt;
    ASNIfBranch falseStmt;

    public ASNIfStmt(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    @Override
    public void build(){
        for(ASN child :children){
            if(child instanceof ASNIfBranch){
                if(((ASNIfBranch) child).dir) trueStmt= (ASNIfBranch) child;
                else falseStmt= (ASNIfBranch) child;
            }else if(child instanceof ASNExpr){
                ifCondition=(ASNExpr) child;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        ifCondition.check();
        if(trueStmt!=null) trueStmt.check();
        if(falseStmt!=null) falseStmt.check();
        if(!ifCondition.returnType.equals(BooleanType)) throw new InvalidStmt();
    }

    int formerIndex;
    int conditionIndex;
    int trueStmtIndex;
    int falseStmtIndex;
    int forwardIndex;

    @Override
    public void controlFlowAnalysis(List<IRBlock> blocks) {
        formerIndex=blocks.size()-1;
        conditionIndex=formerIndex+1;
        blocks.add(new IRBlock());
        if(trueStmt!=null){
            blocks.add(new IRBlock());
            trueStmtIndex= blocks.size()-1;
        }
        if(falseStmt!=null){
            blocks.add(new IRBlock());
            falseStmtIndex= blocks.size()-1;
        }
        blocks.add(new IRBlock());
        formerIndex=blocks.size()-1;
    }
}

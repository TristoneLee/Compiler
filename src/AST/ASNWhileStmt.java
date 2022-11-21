package AST;

import IR.IRBlock;
import IR.IRUtility.IRScopeBuffer;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidStmt;

import java.util.List;


import static utility.ValueType.BooleanType;

public class ASNWhileStmt extends ASNStmt{
    ASNExpr whileCondition;
    ASNStmt whileStmt;
    public ASNWhileStmt(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
    }

    @Override
    public void build(){
        for(ASN child :children){
            if(child instanceof ASNStmt){
                whileStmt= (ASNStmt) child;
            }else if(child instanceof ASNExpr){
                whileCondition=(ASNExpr) child;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        whileCondition.check();
        if(!whileCondition.returnType.equals(BooleanType)) throw new InvalidStmt();
        scopeBuffer.push(new Scope());
        scopeBuffer.controlFlow.push(this);
        whileStmt.check();
        scopeBuffer.pop();
        scopeBuffer.controlFlow.pop();
    }

    int formerIndex;
    int conditionIndex;
    int bodyIndex;
    int forwardIndex;

    @Override
    public void controlFlowAnalysis(List<IRBlock> blocks) {
        formerIndex=blocks.size()-1;
        blocks.add(new IRBlock());
        conditionIndex=blocks.size()-1;
        blocks.add(new IRBlock());
        bodyIndex=blocks.size()-1;
        blocks.add(new IRBlock());
        forwardIndex= blocks.size()-1;
    }

    @Override
    public int irGeneration(List<IRBlock> blocks, Integer localVarIndex, Integer curBlock, IRScopeBuffer irScopeBuffer) {
        whileCondition.irGeneration(blocks,localVarIndex,conditionIndex,irScopeBuffer);
        whileStmt.irGeneration(blocks,localVarIndex,bodyIndex,irScopeBuffer);
        curBlock=forwardIndex;
        return 0;
    }
}

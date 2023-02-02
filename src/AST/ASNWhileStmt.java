package AST;

import IR.IRBlock;
import IR.IRBuilder;
import IR.IRFunction;
import IR.IRIns.IRBr;
import IR.IRIns.IRCondBr;
import IR.IRUtility.IRVar;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidStmt;


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
    public void controlFlowAnalysis(IRBuilder irBuilder,IRFunction irFunction) {
        var blocks=irFunction.blocks;
        formerIndex=blocks.size()-1;
        blocks.add(new IRBlock());
        conditionIndex=blocks.size()-1;
        blocks.add(new IRBlock());
        bodyIndex=blocks.size()-1;
        whileStmt.controlFlowAnalysis(irBuilder,irFunction);
        blocks.add(new IRBlock());
        forwardIndex= blocks.size()-1;
        irFunction.setBreakBlock(bodyIndex,forwardIndex);
        irFunction.setContinueBlock(bodyIndex,conditionIndex);
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        irFunction.curBlock=conditionIndex;
        var condVar=whileCondition.irGeneration(irBuilder,irFunction);
        irFunction.addIns(conditionIndex,new IRCondBr(condVar,bodyIndex,forwardIndex));
        irFunction.curBlock=bodyIndex;
        whileStmt.irGeneration(irBuilder,irFunction);
        irFunction.addIns(bodyIndex,new IRBr(conditionIndex));
        irFunction.curBlock=forwardIndex;
        return null;
    }
}

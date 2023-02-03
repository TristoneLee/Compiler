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

    IRBlock conditionIndex=new IRBlock();
    IRBlock bodyIndex=new IRBlock();
    IRBlock forwardIndex=new IRBlock();


    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        irFunction.addIns(new IRBr(conditionIndex));
        irFunction.blocks.add(conditionIndex);
        irFunction.curBlock=conditionIndex;
        var condVar=whileCondition.irGeneration(irBuilder,irFunction);
        irFunction.addIns(new IRCondBr(condVar,bodyIndex,forwardIndex));
        irFunction.blocks.add(bodyIndex);
        irFunction.curBlock=bodyIndex;
        var oldBreak=irFunction.breakBlock;
        var oldContinue=irFunction.continueBlock;
        irFunction.setBreakBlock(forwardIndex);
        irFunction.setContinueBlock(conditionIndex);
        whileStmt.irGeneration(irBuilder,irFunction);
        irFunction.setBreakBlock(oldBreak);
        irFunction.setContinueBlock(oldContinue);
        irFunction.addIns(new IRBr(conditionIndex));
        irFunction.curBlock=forwardIndex;
        irFunction.blocks.add(forwardIndex);
        return null;
    }
}

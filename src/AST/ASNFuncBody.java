package AST;

import IR.IRBlock;
import IR.IRUtility.IRScopeBuffer;
import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.ArrayList;
import java.util.List;

public class ASNFuncBody extends ASN {
    public List<ASNStmt> statements = new ArrayList<>();

    public ASNFuncBody(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
    }

    @Override
    public void build() {
        for (ASN child : children) statements.add((ASNStmt) child);
    }

    @Override
    public void check() throws CompileException {
        for (ASNStmt stmt : statements) {
            stmt.check();
        }
    }

    @Override
    public int irGeneration(List<IRBlock> blocks, Integer localVarIndex, Integer curBlock, IRScopeBuffer irScopeBuffer) {
        controlFlowAnalysis(blocks,0);
        for(ASNStmt stmt:statements){
            stmt.irGeneration(blocks,localVarIndex,curBlock,irScopeBuffer);
        }
        return 0;
    }

    public void controlFlowAnalysis(List<IRBlock> blocks, Integer blockIndex){
        for(ASNStmt stmt:statements){
            stmt.controlFlowAnalysis(blocks);
        }
    }
}

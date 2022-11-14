package AST;

import IR.IRBlock;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static utility.ValueType.IntegerType;
import static utility.ValueType.VoidType;

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
    public void irGeneration(List<IRBlock> blocks, Integer localVarIndex, Integer curBlock) {
        controlFlowAnalysis(blocks,0);
        for(ASNStmt stmt:statements){
            stmt.irGeneration(blocks,localVarIndex,curBlock);
        }
    }

    public void controlFlowAnalysis(List<IRBlock> blocks, Integer blockIndex){
        for(ASNStmt stmt:statements){
            stmt.controlFlowAnalysis(blocks);
        }
    }
}

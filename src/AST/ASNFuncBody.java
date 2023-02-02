package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRVar;
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
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        controlFlowAnalysis(irBuilder,irFunction);
        for(ASNStmt stmt:statements){
            stmt.irGeneration(irBuilder,irFunction);
        }
        return null;
    }

    public void controlFlowAnalysis(IRBuilder irBuilder,IRFunction irFunction){
        for(ASNStmt stmt:statements){
            stmt.controlFlowAnalysis(irBuilder,irFunction);
        }
    }
}

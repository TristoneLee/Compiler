package AST;

import IR.IRBuilder;
import IR.IRFunction;
import IR.IRUtility.IRVar;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;

import java.util.ArrayList;
import java.util.List;

public class ASNIfBranch extends ASN {
    List<ASNStmt> stmts;
    public boolean dir;

    public ASNIfBranch(ScopeBuffer scopeBuffer){
        super(scopeBuffer);
        stmts=new ArrayList<>();
    }

    @Override
    public void build() throws CompileException {
        for(ASN child :children) stmts.add((ASNStmt) child);
    }

    @Override
    public void check() throws CompileException {
        scopeBuffer.push(new Scope());
        for(ASNStmt stmt:stmts) stmt.check();
        scopeBuffer.pop();
    }

    @Override
    public IRVar irGeneration(IRBuilder irBuilder, IRFunction irFunction) {
        for(var stmt:stmts){
            stmt.irGeneration(irBuilder,irFunction);
        }
        return null;
    }
}

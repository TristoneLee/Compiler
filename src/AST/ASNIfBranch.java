package src.AST;

import src.parser.Scope;
import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;

import java.util.ArrayList;
import java.util.List;

public class ASNIfBranch extends ASN {
    List<ASNStmt> stmts;
    public boolean dir;

    public ASNIfBranch(ScopeBuffer scopeBuffer){
        super("TrueStmt",scopeBuffer);
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
}

package AST;

import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static utility.ValueType.IntegerType;
import static utility.ValueType.VoidType;

public class ASNFuncBody extends ASN {
    List<ASNStmt> statements = new ArrayList<>();

    public ASNFuncBody(ScopeBuffer scopeBuffer) {
        super("FuncBody", scopeBuffer);
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
}

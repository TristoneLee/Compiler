package src.AST;

import src.parser.Scope;
import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidStmt;

import java.util.ArrayList;
import java.util.List;


import static src.utility.ValueType.BooleanType;

public class ASNWhileStmt extends ASNStmt{
    ASNExpr whileCondition;
    List<ASNStmt> statements;
    public ASNWhileStmt(ScopeBuffer scopeBuffer){
        super("WhileStmt",scopeBuffer);
        statements=new ArrayList<>();
    }

    @Override
    public void build(){
        for(ASN child :children){
            if(child instanceof ASNStmt){
                statements.add((ASNStmt) child);
            }else if(child instanceof ASNExpr){
                whileCondition=(ASNExpr) child;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        whileCondition.check();
        if(whileCondition.returnType!=BooleanType) throw new InvalidStmt();
        scopeBuffer.push(new Scope());
        for(ASNStmt stmt:statements) stmt.check();
        scopeBuffer.pop();
    }
}

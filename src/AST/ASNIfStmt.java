package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidStmt;

import java.util.List;
import java.util.Stack;

import static src.utility.ValueType.BooleanType;

public class ASNIfStmt extends ASNStmt{
    ASNExpr ifCondition;
    List<ASNStmt> statements;

    public ASNIfStmt(ScopeBuffer scopeBuffer){
        super("IfStmt",scopeBuffer);
    }

    @Override
    public void build(){
        for(ASN child :children){
            if(child instanceof ASNStmt){
                statements.add((ASNStmt) child);
            }else if(child instanceof ASNExpr){
                ifCondition=(ASNExpr) child;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        ifCondition.check();
        for(ASNStmt stmt : statements){
            stmt.check();
        }
        if(ifCondition.returnType!=BooleanType) throw new InvalidStmt();
    }
}

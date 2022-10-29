package src.AST;

import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static src.utility.ValueType.IntegerType;
import static src.utility.ValueType.VoidType;

public class ASNFuncBody extends ASN{
    ValueType returnType;

    boolean ifMain;
    List<ASNStmt> statements=new ArrayList<>();
    public ASNFuncBody(ScopeBuffer scopeBuffer){
        super("FuncBody",scopeBuffer);
    }

    @Override
    public void build(){
        for(ASN child:children)statements.add((ASNStmt) child);
    }

    @Override
    public void check() throws CompileException {
        boolean ifHaveReturn=false;
        for(ASNStmt stmt:statements){
            stmt.check();
            if(stmt instanceof ASNReturnStmt) {
                if(!((ASNReturnStmt) stmt).returnType.equals(returnType)) throw new CompileException("UnmatchedReturnType");
                ifHaveReturn=true;
            }
        }
        if(!ifHaveReturn){
            if(!ifMain&&!returnType.equals(VoidType)) throw new CompileException("NoReturn");
        }
    }
}

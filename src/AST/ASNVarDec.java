package src.AST;

import src.utility.Exception.CompileException;
import src.utility.Parameter;

import java.util.List;

public class ASNVarDec extends ASNStmt{
    public ASNVarDec(){
        super("VarDec");
    }

    @Override
    public void build() throws CompileException {
    }
}

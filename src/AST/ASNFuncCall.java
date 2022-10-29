package src.AST;

import src.parser.ClassEntity;
import src.parser.FunctionEntity;
import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidExpression;
import src.utility.Exception.UndeifinedVariety;
import src.utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ASNFuncCall extends ASNExpr {
    String funcName;
    List<ASNExpr> parameters;

    public ASNFuncCall(ScopeBuffer scopeBuffer) {
        super("FuncCall", scopeBuffer);
        parameters=new ArrayList<>();
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNStringConst) funcName = ((ASNStringConst) child).value;
            else if (child instanceof ASNExpr) parameters.add((ASNExpr) child);
            else throw new InvalidExpression();
        }
    }

    @Override
    public void check() throws CompileException {
        for(ASNExpr expr:parameters) expr.check();
        FunctionEntity entity = scopeBuffer.searchFunc(funcName);
        if (entity==null)throw new CompileException("UndefinedFunction");
        if (entity.paraList.size()!=parameters.size()) throw new CompileException("UndefinedFunction");
        for(int i=0;i<parameters.size();++i){
            if(!entity.paraList.get(i).valueType.equals(parameters.get(i).returnType)) throw new CompileException("UnmatchedParameter");
        }
        returnType=entity.returnType;
    }
}

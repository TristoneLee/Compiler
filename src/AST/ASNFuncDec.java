package src.AST;

import src.parser.FunctionEntity;
import src.parser.Scope;
import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Exception.InvalidExpression;
import src.utility.Parameter;
import src.utility.ValueType;

import static src.utility.ValueType.IntegerType;
import static src.utility.ValueType.VoidType;


public class ASNFuncDec extends ASNStmt {
    public FunctionEntity entity = new FunctionEntity();
    public ASNFuncBody funcBody;

    public ASNFuncDec(ScopeBuffer scopeBuffer) {
        super("FuncDec", scopeBuffer);
    }

    @Override
    public void build() throws CompileException {
        for (ASN child : children) {
            if (child instanceof ASNTypeSpecifier) entity.returnType = ((ASNTypeSpecifier) child).valueType;
            else if (child instanceof ASNParameter) {
                entity.paraList.add(((ASNParameter) child).parameter);
            } else if (child instanceof ASNFuncBody) funcBody = (ASNFuncBody) child;
            else if (child instanceof ASNStringConst) entity.functionName = ((ASNStringConst) child).value;
            else throw new InvalidExpression();
        }
    }

    @Override
    public void check() throws CompileException {
        if(entity.functionName.equals("main")){
            if(!entity.returnType.equals(IntegerType)) throw new CompileException("InvalidMainFuncReturn");
        }
        funcBody.returnType = entity.returnType;
        funcBody.ifMain = entity.functionName.equals("main");
        scopeBuffer.push(new Scope());
        for(Parameter para:entity.paraList)scopeBuffer.addVariable(para.name, para.valueType);
        funcBody.check();
        scopeBuffer.pop();
    }
}

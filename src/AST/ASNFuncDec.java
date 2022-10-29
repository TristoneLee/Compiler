package AST;

import parser.FunctionEntity;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;
import utility.Parameter;
import utility.ValueType;

import static utility.ValueType.IntegerType;
import static utility.ValueType.VoidType;


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
            if(entity.paraList.size()!=0) throw new CompileException("InvalidMainFuncPara");
        }
        funcBody.returnType = entity.returnType;
        funcBody.ifMain = entity.functionName.equals("main");
        scopeBuffer.push(new Scope());
        for(Parameter para:entity.paraList)scopeBuffer.addVariable(para.name, para.valueType);
        funcBody.check();
        scopeBuffer.pop();
    }
}

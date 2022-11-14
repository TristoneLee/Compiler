package AST;

import IR.IRBlock;
import parser.FunctionEntity;
import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Exception.InvalidExpression;
import utility.Parameter;
import utility.ValueType;

import java.util.List;
import java.util.Objects;

import static utility.ValueType.IntegerType;
import static utility.ValueType.VoidType;


public class ASNFuncDec extends ASNStmt {
    public FunctionEntity entity = new FunctionEntity();
    public ASNFuncBody funcBody;

    public boolean ifReturn;

    public ASNFuncDec(ScopeBuffer scopeBuffer) {
        super(scopeBuffer);
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
        System.out.println(entity.functionName);
        if (entity.functionName.equals("main")) {
            if (!entity.returnType.equals(IntegerType)) throw new CompileException("InvalidMainFuncReturn");
            if (entity.paraList.size() != 0) throw new CompileException("InvalidMainFuncPara");
        }
        scopeBuffer.push(new Scope());
        scopeBuffer.controlFlow.push(this);
        for (Parameter para : entity.paraList) scopeBuffer.addVariable(para.name, para.valueType);
        funcBody.check();
        if (!((ASNFuncDec) scopeBuffer.controlFlow.peek()).ifReturn && !Objects.equals(entity.functionName, "main") && !Objects.equals(entity.returnType, VoidType))
            throw new CompileException("NoReturn");
        scopeBuffer.controlFlow.pop();
        scopeBuffer.pop();
    }

    @Override
    public void to_IR(List<IRBlock> blocks, Integer localVarIndex, Integer blockIndex) {
    }
}

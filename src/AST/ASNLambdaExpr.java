package src.AST;

import src.parser.Scope;
import src.parser.ScopeBuffer;
import src.utility.Exception.CompileException;
import src.utility.Parameter;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static src.utility.ValueType.VoidType;

public class ASNLambdaExpr extends ASNExpr{
    public enum LambdaType {refer,value};
    LambdaType lambdaType;
    List<Parameter> parameters;
    ASNFuncBody funcBody;
    public ASNLambdaExpr(ScopeBuffer scopeBuffer) {
        super("LambdaExpr",scopeBuffer);
    }

    public void SetType(LambdaType lambdaType_){
        lambdaType=lambdaType_;
    }

    public void build(){
        lambdaType=LambdaType.value;
        for (ASN child : children) {
            if (Objects.equals(child.type,"Parameter")) {
                parameters.add(((ASNParameter) child).parameter);
            } else if (Objects.equals(child.type,"FunctionBody")) {
                funcBody = (ASNFuncBody) child;
            }else if (Objects.equals(child.type,"LambdaReferMark")){
                lambdaType=LambdaType.refer;
            }
        }
    }

    @Override
    public void check() throws CompileException {
        scopeBuffer.push(new Scope());
        for(Parameter parameter:parameters)scopeBuffer.addVariable(parameter.name,parameter.valueType);
        funcBody.check();
        returnType=funcBody.returnType;
        if(returnType==VoidType) throw new CompileException("NoReturnForLambdaExpression");
        scopeBuffer.pop();
    }
}

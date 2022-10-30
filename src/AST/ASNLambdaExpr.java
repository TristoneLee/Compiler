package AST;

import parser.Scope;
import parser.ScopeBuffer;
import utility.Exception.CompileException;
import utility.Parameter;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static utility.ValueType.VoidType;

public class ASNLambdaExpr extends ASNExpr{
    public enum LambdaType {refer,value}
    LambdaType lambdaType;
    List<Parameter> parameters;
    List<ASNExpr> values;
    ASNFuncBody funcBody;
    public ASNLambdaExpr(ScopeBuffer scopeBuffer) {
        super("LambdaExpr",scopeBuffer);
        values=new ArrayList<>();
        parameters=new ArrayList<>();
    }

    public void SetType(LambdaType lambdaType_){
        lambdaType=lambdaType_;
    }

    public void build(){
        lambdaType=LambdaType.value;
        for (ASN child : children) {
            if (child instanceof ASNParameter) {
                parameters.add(((ASNParameter) child).parameter);
            } else if (child instanceof ASNFuncBody) {
                funcBody = (ASNFuncBody) child;
            }else if (child instanceof ASNLambdaReferMark){
                lambdaType=LambdaType.refer;
            }else if(child instanceof ASNExpr){
                values.add((ASNExpr) child);
            }
        }
    }

    @Override
    public void check() throws CompileException {
        if(parameters.size()!=values.size()) throw new CompileException("InvalidLambdaExpr");
        for(int i=0;i<parameters.size();++i){
            values.get(i).check();
            if(!values.get(i).returnType.equals(parameters.get(i).valueType))throw new CompileException("InvalidLambdaExpr");
        }
        scopeBuffer.push(new Scope());
        scopeBuffer.controlFlow.push(this);
        for(Parameter parameter:parameters)scopeBuffer.addVariable(parameter.name,parameter.valueType);
        funcBody.check();
        returnType=((ASNLambdaExpr)scopeBuffer.controlFlow.peek()).returnType;
        if(returnType.equals(VoidType)) throw new CompileException("NoReturnForLambdaExpression");
        scopeBuffer.controlFlow.pop();
        scopeBuffer.pop();
    }
}

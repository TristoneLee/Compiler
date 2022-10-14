package src.AST;

import src.utility.Parameter;

import java.util.List;
import java.util.Objects;

public class ASNLambdaExpr extends ASN{
    public enum LambdaType {refer,value};
    LambdaType lambdaType;
    List<Parameter> parameters;
    ASNFuncBody funcBody;
    public ASNLambdaExpr() {
        super("LambdaExpr");
    }

    public void SetType(LambdaType lambdaType_){
        lambdaType=lambdaType_;
    }

    public void build(){
        lambdaType=LambdaType.value;
        for (ASN child : children) {
            if (Objects.equals(child.type,"Parameter")) {
                parameters.add(((ASNParameter) child).getParamter());
            } else if (Objects.equals(child.type,"FunctionBody")) {
                funcBody = (ASNFuncBody) child;
            }else if (Objects.equals(child.type,"LambdaReferMark")){
                lambdaType=LambdaType.refer;
            }
        }
    }
}

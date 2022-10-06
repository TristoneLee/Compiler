package src.AST;

import src.utility.Parameter;

import java.util.List;

public class ASNLambdaExpr extends ASN{
    public enum LambdaType {refer,vaule};
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
        for (ASN child : children) {
            if (child instanceof ASNParameter) {
                parameters.add(((ASNParameter) child).getParamter());
            } else if (child instanceof ASNFuncBody) {
                funcBody = (ASNFuncBody) child;
            }
        }
    }
}

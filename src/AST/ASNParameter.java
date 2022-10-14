package src.AST;

import src.utility.Parameter;

import java.util.Objects;

public class ASNParameter extends ASN {

    Parameter parameter;

    public ASNParameter() {
        super("Parameter");
    }

    public Parameter getParamter() {
        return parameter;
    }

    public void build(){
        for(ASN child :children){
            if(Objects.equals(child.type, "StringConst")){
                parameter.name=((ASNStringConst) child).value;
            }else if(Objects.equals(child.type,"TypeSpecifier")){
                parameter.dimension=((ASNTypeSpecifier) child).dimension;
                parameter.dimensions=((ASNTypeSpecifier) child).dimensions;
                parameter.baseType=((ASNTypeSpecifier) child).baseType;
            }
        }
    }
}

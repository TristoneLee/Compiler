package src.AST;

import src.utility.Parameter;

public class ASNParameter extends ASN {

    Parameter parameter;

    public ASNParameter() {
        super("Parameter");
    }

    public Parameter getParamter() {
        return parameter;
    }
}

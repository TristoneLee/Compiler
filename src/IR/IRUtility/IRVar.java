package IR.IRUtility;

/*
A pair used to denote the value in IR distinguishing immediate number and value in reg
 */

import utility.Parameter;

import java.util.List;

public class IRVar {
    String type;

    public IRVar(Parameter parameter) {
        if (parameter.valueType.dimension == 0) {
            type = parameter.valueType.baseType;
        } else type = "int";
    }
}

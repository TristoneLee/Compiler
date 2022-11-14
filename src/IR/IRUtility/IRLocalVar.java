package IR.IRUtility;

import utility.Parameter;

public class IRLocalVar extends IRVar{
    int index;

    public IRLocalVar(Parameter parameter,int index_){
        super(parameter);
        index=index_;
    }
}

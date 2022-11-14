package IR.IRUtility;

import utility.Parameter;

public class IRGlobVar extends IRVar{
    String varName;

    public IRGlobVar(Parameter para,String name){
        super(para);
        varName=name;
    }
}

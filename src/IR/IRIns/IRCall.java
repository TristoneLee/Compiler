package IR.IRIns;

import IR.IRFunction;
import IR.IRUtility.IRVar;

import java.util.ArrayList;
import java.util.List;

public class IRCall extends IRIns {
    public IRFunction function;
    public List<IRVar> paras = new ArrayList<>();
    public IRVar returnVar;
    public String funcName = "";
    public boolean ifInBuild=false;

    public IRCall(String funcName_){
        funcName=funcName_;
        ifInBuild=true;
    }

    public IRCall(IRFunction irFunction){
        function=irFunction;
        funcName= irFunction.funcName;
        ifInBuild=false;
    }

    public IRCall(){}

    @Override
    public String toString() {
        String paraString = "";
        if (!paras.isEmpty()) {
            for (var para : paras) {
                paraString = paraString + para.toString() + ", ";
            }
            paraString = paraString.substring(0, paraString.length() - 2);
        }
        if (returnVar != null) {
            return returnVar.toString() + " = " + funcName + " (" + paraString + ")";
        } else {
            return "call void "+funcName+" ("+paraString+ ")";
        }
        }
    }

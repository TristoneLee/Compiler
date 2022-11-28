package IR.IRIns;

import IR.IRFunction;
import IR.IRUtility.IRVar;

import java.util.ArrayList;
import java.util.List;

public class IRCall extends IRIns{
    public IRFunction function;
    public List<IRVar> paras=new ArrayList<>();
    public IRVar returnVar;
}

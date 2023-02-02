package IR.IRUtility;

import java.util.HashMap;
import java.util.Map;

public class IRScope {
    public Map<String,IRVar> indexTable=new HashMap<>();

    public void put(String name,IRVar var){
        indexTable.put(name,var);
    }
}

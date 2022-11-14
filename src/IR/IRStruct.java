package IR;

import IR.IRUtility.IRVar;
import parser.ClassEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IRStruct {
    List<IRVar> types;
    static Map<String, Integer> structLengthTable;

    static {
        structLengthTable = new HashMap<>();
        structLengthTable.put("int", 32);
        structLengthTable.put("bool", 8);
        structLengthTable.put("char", 32);
    }

    public IRStruct(ClassEntity entity) {
        entity.classMember.forEach((s, para) -> types.add(new IRVar(para)));
    }
}

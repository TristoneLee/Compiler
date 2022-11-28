package IR;

import IR.IRUtility.IRType;
import parser.ClassEntity;

import java.util.HashMap;
import java.util.Map;

public class IRStruct {
    public Map<String, IRType> memberList = new HashMap<>();
    public Map<String,Integer> memberNum = new HashMap<>();
    public int memberCounter=0;
    public static Map<String, Integer> structLengthTable;
    public IRFunction Constructor;

    static {
        structLengthTable = new HashMap<>();
        structLengthTable.put("int", 32);
        structLengthTable.put("bool", 32);
        structLengthTable.put("char", 32);
    }

    public IRStruct(ClassEntity entity) {
        entity.classMember.forEach((s, para) -> {
            memberList.put(s, new IRType(para.valueType));
            ++memberCounter;
            memberNum.put(s,memberCounter);
        });
    }

    public int getMemberIndex(String memberName){
        return memberNum.get(memberName);
    }
}

package IR;

import IR.IRUtility.IRType;
import parser.ClassEntity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IRStruct {
    public String structName;
    public LinkedHashMap<String, IRType> memberList = new LinkedHashMap<>();
    public LinkedHashMap<String, Integer> memberNum = new LinkedHashMap<>();
    public int memberCounter = 0;
    public static Map<String, Integer> structLengthTable;
    public IRFunction Constructor;
    public ClassEntity asnEntity;

    static {
        structLengthTable = new HashMap<>();
        structLengthTable.put("int", 4);
        structLengthTable.put("bool", 1);
        structLengthTable.put("char", 2);
    }

    public IRStruct(IRBuilder irBuilder, ClassEntity entity) {
        asnEntity=entity;
        structName = entity.className;
        entity.classMethod.forEach((s, method) -> {
            irBuilder.funcs.put(structName+"."+method.functionName, new IRFunction(irBuilder, method.asnFuncDec, this));
        });
        if (asnEntity.classConstructor != null) {
            Constructor = new IRFunction(irBuilder, asnEntity.classConstructor.asnFuncDec, this);
            irBuilder.funcs.put(structName+".Constructor",Constructor);
        }
    }

    public void structBuild(IRBuilder irBuilder){
        asnEntity.classMember.forEach((s, para) -> {
            memberList.put(s, new IRType(para.valueType,irBuilder));
            memberNum.put(s, memberCounter++);
        });

    }

    public int getMemberIndex(String memberName) {
        return memberNum.get(memberName);
    }

    public int getMemberOffset(String memberName){
        int offset=0;
        for(var bi:memberList.entrySet()){
            if(memberName.equals(bi.getKey())) break;
            else offset+=bi.getValue().getSize();
        }
        return offset;
    }

    public int getStructSize(){
        int size=0;
        for(var member:memberList.values()){
            size+=member.getSize();
        }
        return size;
    }

    public void print(){

    }
}

package parser;

import utility.Parameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utility.ValueType.IntegerType;
import static utility.ValueType.StringType;

public class ClassEntity {
    public String className;
    public Map<String, Parameter> classMember;
    public Map<String, FunctionEntity> classMethod;

    public ClassEntity() {
        classMethod = new HashMap<>();
        classMember = new HashMap<>();
    }

    public static ClassEntity stringClass;
    static {
        stringClass= new ClassEntity();
        stringClass.className = "String";

        FunctionEntity stringLength = new FunctionEntity();
        stringLength.functionName = "Length";
        stringLength.returnType = IntegerType;

        FunctionEntity stringSubstring = new FunctionEntity();
        stringSubstring.functionName = "substring";
        stringSubstring.returnType = StringType;
        List<Parameter> subStringParas = new ArrayList<>();
        subStringParas.add(new Parameter("left", IntegerType));
        subStringParas.add(new Parameter("right", IntegerType));
        stringSubstring.paraList = subStringParas;

        FunctionEntity parserInt = new FunctionEntity();
        parserInt.functionName = "parserInt";
        parserInt.returnType = IntegerType;

        FunctionEntity ord = new FunctionEntity();
        ord.returnType = IntegerType;
        ord.functionName = "ord";
        ord.paraList = new ArrayList<>();
        ord.paraList.add(new Parameter("pos", IntegerType));

        stringClass.classMethod.put("length", stringLength);
        stringClass.classMethod.put("substring", stringSubstring);
        stringClass.classMethod.put("parseInt", parserInt);
        stringClass.classMethod.put("ord", ord);
    }

    public static ClassEntity arrayClass;
    static{
        arrayClass=new ClassEntity();
        arrayClass.className="";

        FunctionEntity funcSize;
        funcSize=new FunctionEntity();
        funcSize.functionName="size";
        funcSize.returnType=IntegerType;
        funcSize.paraList=new ArrayList<>();

        arrayClass.classMethod.put("size",funcSize);
    }
}

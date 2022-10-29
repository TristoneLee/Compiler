package src.parser;

import src.utility.Parameter;
import src.utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static src.utility.ValueType.*;

public class FunctionEntity {
    public String functionName;
    public ValueType returnType;
    public List<Parameter> paraList;

    public FunctionEntity(){
        paraList=new ArrayList<>();
    }

    public static FunctionEntity funcPrint;
    public static FunctionEntity funcPrintln;
    public static FunctionEntity funcPrintInt;
    public static FunctionEntity funcPrintlnInt;
    public static FunctionEntity funcGetString;
    public static FunctionEntity funcGetInt;
    public static FunctionEntity funcToString;


    static {
        funcPrint=new FunctionEntity();
        funcPrint.functionName="print";
        funcPrint.returnType=VoidType;
        funcPrint.paraList=new ArrayList<>();
        funcPrint.paraList.add(new Parameter("str",StringType));

        funcPrintln=new FunctionEntity();
        funcPrintln.functionName="println";
        funcPrintln.returnType=VoidType;
        funcPrintln.paraList=new ArrayList<>();
        funcPrintln.paraList.add(new Parameter("str",StringType));

        funcPrintInt=new FunctionEntity();
        funcPrintInt.functionName="printInt";
        funcPrintInt.returnType=VoidType;
        funcPrintInt.paraList=new ArrayList<>();
        funcPrintInt.paraList.add(new Parameter("n",IntegerType));

        funcPrintlnInt=new FunctionEntity();
        funcPrintlnInt.functionName="printlnInt";
        funcPrintlnInt.returnType=VoidType;
        funcPrintlnInt.paraList=new ArrayList<>();
        funcPrintlnInt.paraList.add(new Parameter("n",IntegerType));

        funcGetString=new FunctionEntity();
        funcGetString.functionName="getString";
        funcGetString.returnType=StringType;
        funcGetString.paraList=new ArrayList<>();

        funcGetInt=new FunctionEntity();
        funcGetInt.functionName="getInt";
        funcGetInt.returnType=IntegerType;
        funcGetInt.paraList=new ArrayList<>();

        funcToString=new FunctionEntity();
        funcToString.functionName="toString";
        funcToString.returnType=StringType;
        funcToString.paraList=new ArrayList<>();
        funcToString.paraList.add(new Parameter("i",IntegerType));
    }
}


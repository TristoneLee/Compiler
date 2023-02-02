package parser;

import AST.ASNFuncDec;
import utility.Parameter;
import utility.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static utility.ValueType.*;

public class FunctionEntity {
    public String functionName;
    public ValueType returnType;
    public List<Parameter> paraList;
    public ASNFuncDec asnFuncDec;

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
        funcPrint.functionName="__PRINT";
        funcPrint.returnType=VoidType;
        funcPrint.paraList=new ArrayList<>();
        funcPrint.paraList.add(new Parameter("str",StringType));

        funcPrintln=new FunctionEntity();
        funcPrintln.functionName="__PRINTLN";
        funcPrintln.returnType=VoidType;
        funcPrintln.paraList=new ArrayList<>();
        funcPrintln.paraList.add(new Parameter("str",StringType));

        funcPrintInt=new FunctionEntity();
        funcPrintInt.functionName="__PRINT_INT";
        funcPrintInt.returnType=VoidType;
        funcPrintInt.paraList=new ArrayList<>();
        funcPrintInt.paraList.add(new Parameter("n",IntegerType));

        funcPrintlnInt=new FunctionEntity();
        funcPrintlnInt.functionName="__PRINTLN_INT";
        funcPrintlnInt.returnType=VoidType;
        funcPrintlnInt.paraList=new ArrayList<>();
        funcPrintlnInt.paraList.add(new Parameter("n",IntegerType));

        funcGetString=new FunctionEntity();
        funcGetString.functionName="__GET_STRING";
        funcGetString.returnType=StringType;
        funcGetString.paraList=new ArrayList<>();

        funcGetInt=new FunctionEntity();
        funcGetInt.functionName="__GET_INT";
        funcGetInt.returnType=IntegerType;
        funcGetInt.paraList=new ArrayList<>();

        funcToString=new FunctionEntity();
        funcToString.functionName="__TO_STRING";
        funcToString.returnType=StringType;
        funcToString.paraList=new ArrayList<>();
        funcToString.paraList.add(new Parameter("i",IntegerType));
    }
}


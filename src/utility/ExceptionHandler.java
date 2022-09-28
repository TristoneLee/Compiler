package src.utility;

import src.Compiler;

public class ExceptionHandler {
    public static void Handle(CompileException exception){
        exception.Call();
    }
}

abstract class CompileException extends Exception{
    public abstract void Call();
}

abstract class StaticCompileException extends CompileException{
    public abstract void Call();
}

class UndeifinedVariety extends StaticCompileException{
    String name;
    int array,line;

    public void Call(){
        System.err.println("Error: Undefined variety %v in line %v array %v.");
    }
}

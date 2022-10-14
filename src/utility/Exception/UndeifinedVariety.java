package src.utility.Exception;


public class UndeifinedVariety extends CompileException {
    String name;
    int array, line;

    public void Call() {
        System.err.println("Error: Undefined variety %v in line %v array %v.");
    }
}

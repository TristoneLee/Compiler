package utility.Exception;


public class UndeifinedVariety extends CompileException {
    public UndeifinedVariety() {
        super("UndefinedVariety");
    }

    public void Call() {
        System.err.println("Error: UndefinedVariety ");
    }
}

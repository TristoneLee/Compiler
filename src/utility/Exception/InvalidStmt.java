package src.utility.Exception;

public class InvalidStmt extends CompileException {
    public InvalidStmt() {
        super("InvalidStmt");
    }

    public void Call() {
        System.err.println("Error: InvalidStmt");
    }
}
package src.utility.Exception;

public class InvalidExpression extends CompileException {
    public InvalidExpression() {
        super("InvalidExpression");
    }

    public void Call() {
        System.err.println("Error: InvalidExpression");
    }
}
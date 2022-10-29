package src.utility.Exception;

public class InvalidArrayType extends CompileException {
    public InvalidArrayType() {
        super("InvalidArrayType");
    }

    public void Call() {
        System.err.println("Error: InvalidArrayType");
    }
}

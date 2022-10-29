package src.utility.Exception;

public class Redeclarification extends CompileException{
    String name;
    public void Call() {
        System.err.println("Error: Redeclarification of "+name);
    }

    public Redeclarification(String name_){
        super("Redeclarification");
        name=name_;
    }
}

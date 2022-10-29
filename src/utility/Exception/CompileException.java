package src.utility.Exception;

public class CompileException extends RuntimeException {
    String msg;

    public CompileException(String msg_){
        msg=msg_;
    }
    public void Call(){
        System.err.println("Error: "+msg);
    }
}

package utility.Exception;

public class SyntaxException extends RuntimeException{
    public SyntaxException(String msg) {
        throw new RuntimeException(msg);
    }
}

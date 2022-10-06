package src.utility;

public class Symbol {
    public enum symbolType{Class,Variable,Function}

    public symbolType type;
    public String name;

    public Symbol(symbolType type_, String name_) {
        type=type_;
        name=name_;
    }

}

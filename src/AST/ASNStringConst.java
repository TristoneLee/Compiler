package src.AST;

public class ASNStringConst extends ASN {
    String value;

    public ASNStringConst(String value_) {
        super("StringConst");
        value = value_;
    }
}

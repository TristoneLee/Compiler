package src.AST;

public class ASNIntConst extends ASN{
    Integer value;

    ASNIntConst(Integer value_) {
        super("IntConst");
        value=value_;
    }
}

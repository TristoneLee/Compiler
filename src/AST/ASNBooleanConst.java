package src.AST;

public class ASNBooleanConst extends ASN{
    Boolean value;

    ASNBooleanConst(Boolean value_){
        super("BooleanConst");
        value=value_;
    }
}

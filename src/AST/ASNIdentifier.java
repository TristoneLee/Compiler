package src.AST;

public class ASNIdentifier extends ASN{
    String identifier;

    public ASNIdentifier(){
        super("Identifier");
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier_){
        identifier=identifier_;
    }
}

package src.AST;

import java.util.Objects;

public class ASNTypeSpecifier extends ASN {
    String basetype;
    int dimension;

    public ASNTypeSpecifier(){
        super("TypeSpecifier");
    }

    public void build(){
        for(ASN child: children){
            if (Objects.equals(child.type, ""))
        }
    }
}

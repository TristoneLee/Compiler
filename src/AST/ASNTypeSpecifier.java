package src.AST;

import java.util.List;
import java.util.Objects;

public class ASNTypeSpecifier extends ASN {
    String baseType;
    int dimension;
    List<Integer> dimensions;
    public ASNTypeSpecifier(){
        super("TypeSpecifier");
    }
    public void build(){
        for(ASN child : children){
            switch (child.type) {
                case "StringConst" -> baseType = ((ASNStringConst) child).value;
                case "ArrayUni" -> {
                    ++dimension;
                    dimensions.add(((ASNArrayUni) child).num);
                }
            }
        }
    }


}

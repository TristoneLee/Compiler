package utility;

import java.util.List;

public class Parameter {
    public String name;
    public ValueType valueType;

    public Parameter(String value_, ValueType valueType_) {
        name=value_;
        valueType=valueType_;
    }

    public Parameter(){
        valueType=new ValueType();
    }
}

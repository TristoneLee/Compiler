package src.utility;

import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValueType {
    public String baseType;
    public int dimension;
    public List<Integer> dimensions;

    public ValueType(String baseType_) {
        dimensions = new ArrayList<>();
        baseType = baseType_;
        dimension = 0;
    }

    public ValueType() {
        dimensions = new ArrayList<>();
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof ValueType rhs) {
            if (!this.baseType.equals(rhs.baseType)) return false;
            if (this.dimensions.size() != rhs.dimensions.size()) return false;
            for (int i = 0; i < this.dimensions.size(); ++i) {
                if (this.dimensions.get(i) != 0 && rhs.dimensions.get(i) != 0 && this.dimensions.get(i) != rhs.dimensions.get(i))
                    return false;
            }
        }
        return true;
    }

    public static ValueType StringType = new ValueType("string");
    public static ValueType IntegerType = new ValueType("int");
    public static ValueType BooleanType = new ValueType("bool");
    public static ValueType NullType = new ValueType("null");
    public static ValueType VoidType = new ValueType("void");
}

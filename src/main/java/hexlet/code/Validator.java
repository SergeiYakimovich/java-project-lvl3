package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

import java.util.Map;

public class Validator {

    public static StringSchema string() {
        return new StringSchema(String.class);
    }

    public static NumberSchema number() {
        return new NumberSchema(Integer.class);
    }

    public static MapSchema map() {
        return new MapSchema(Map.class);
    }

}

package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    public static StringSchema string() {
        return new StringSchema();
    }

    public static NumberSchema number() {
        return new NumberSchema();
    }

}

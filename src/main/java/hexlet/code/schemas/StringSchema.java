package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema(Class requiredClassValue) {
        super(requiredClassValue);
    }

    @Override
    public final StringSchema required() {
        Predicate<String> func = x -> x.length() != 0;
        addValidationList(func);
        setRequiredOn(true);
        return this;
    }

    public final StringSchema contains(String subStr) {
        Predicate<String> func = x -> x.contains(subStr);
        addValidationList(func);
        return this;
    }

    public final StringSchema minLength(int length) {
        Predicate<String> func = x -> x.length() >= length;
        addValidationList(func);
        return this;
    }

}

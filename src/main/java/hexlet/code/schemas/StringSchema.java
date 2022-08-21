package hexlet.code.schemas;

import hexlet.code.Validation;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema(Class requiredClassValue) {
        super(requiredClassValue);
    }
    @Override
    public final StringSchema required() {
        Predicate<String> func = x -> x.length() != 0;
        addValidationList(new Validation(func));
//        setRequiredClass(String.class);
        setRequiredOn(true);
        return this;
    }

    public final StringSchema contains(String subStr) {
        Predicate<String> func = x -> x.contains(subStr);
        addValidationList(new Validation(func));
//        setRequiredClass(String.class);
        return this;
    }

    public final StringSchema minLength(int length) {
        Predicate<String> func = x -> x.length() >= length;
        addValidationList(new Validation(func));
//        setRequiredClass(String.class);
        return this;
    }

}

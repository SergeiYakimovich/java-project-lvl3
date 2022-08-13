package hexlet.code.schemas;

import hexlet.code.Validation;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    @Override
    public final StringSchema required() {
        Predicate<String> func = x -> x.length() != 0;
        setValidationList(new Validation(func));
        setRequiredClass(String.class);
        setRequiredOn(true);
        return this;
    }

    public final StringSchema contains(String subStr) {
        Predicate<String> func = x -> x.contains(subStr);
        setValidationList(new Validation(func));
        setRequiredClass(String.class);
        return this;
    }

    public final StringSchema minLength(int length) {
        Predicate<String> func = x -> x.length() >= length;
        setValidationList(new Validation(func));
        setRequiredClass(String.class);
        return this;
    }

}

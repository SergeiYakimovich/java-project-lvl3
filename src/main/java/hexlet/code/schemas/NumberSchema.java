package hexlet.code.schemas;

import hexlet.code.Validation;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public final NumberSchema positive() {
        Predicate<Integer> func = x -> x > 0;
        setValidationList(new Validation(func, Integer.class));
        return this;
    }

    public final NumberSchema range(int min, int max) {
        Predicate<Integer> func = x -> x >= min && x <= max;
        setValidationList(new Validation(func, Integer.class));
        return this;
    }

    @Override
    public final NumberSchema required() {
        Predicate<Integer> func = x -> true;
        setValidationList(new Validation(func, Integer.class));
        setRequiredOn(true);
        return this;
    }

}

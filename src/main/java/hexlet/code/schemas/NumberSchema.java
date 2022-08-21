package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema(Class requiredClassValue) {
        super(requiredClassValue);
    }

    public final NumberSchema positive() {
        Predicate<Integer> func = x -> x > 0;
        addValidationList(func);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        Predicate<Integer> func = x -> x >= min && x <= max;
        addValidationList(func);
        return this;
    }

    @Override
    public final NumberSchema required() {
        setRequiredOn(true);
        return this;
    }

}

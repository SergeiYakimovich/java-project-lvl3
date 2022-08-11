package hexlet.code.schemas;

import hexlet.code.validations.PositiveValidation;
import hexlet.code.validations.RangeValidation;
import hexlet.code.validations.RequiredValidation;

public class NumberSchema extends BaseSchema {

    public final NumberSchema positive() {
        setValidationList(new PositiveValidation());
        return this;
    }

    public final NumberSchema range(int minValue, int maxValue) {
        setValidationList(new RangeValidation(minValue, maxValue));
        return this;
    }

    @Override
    public final NumberSchema required() {
        setValidationList(new RequiredValidation(Integer.class));
        setRequiredOn(true);
        return this;
    }

}

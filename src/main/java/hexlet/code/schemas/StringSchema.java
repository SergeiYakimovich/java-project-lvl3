package hexlet.code.schemas;

import hexlet.code.validations.ContainsValidation;
import hexlet.code.validations.MinLengthValidation;
import hexlet.code.validations.RequiredValidation;

public class StringSchema extends BaseSchema {

    @Override
    public final StringSchema required() {
        setValidationList(new RequiredValidation(String.class));
        setRequiredOn(true);
        return this;
    }

    public final StringSchema contains(String subStrValue) {
        setValidationList(new ContainsValidation(subStrValue));
        return this;
    }

    public final StringSchema minLength(int lengthValue) {
        setValidationList(new MinLengthValidation(lengthValue));
        return this;
    }

}

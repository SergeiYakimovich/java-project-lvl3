package hexlet.code.schemas;

import hexlet.code.validations.RequiredValidation;
import hexlet.code.validations.ShapeValidation;
import hexlet.code.validations.SizeValidation;
import java.util.Map;

public class MapSchema extends BaseSchema {

    public final MapSchema sizeof(int sizeValue) {
        setValidationList(new SizeValidation(sizeValue));
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> mapValue) {
        setValidationList(new ShapeValidation(mapValue));
        return this;
    }

    @Override
    public final MapSchema required() {
        setValidationList(new RequiredValidation(Map.class));
        setRequiredOn(true);
        return this;
    }

}

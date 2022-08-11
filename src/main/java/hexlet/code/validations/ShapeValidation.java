package hexlet.code.validations;

import hexlet.code.schemas.BaseSchema;

import java.util.Map;

public class ShapeValidation extends Validation {
    private Map<String, BaseSchema> map;

    public ShapeValidation(Map<String, BaseSchema> mapValue) {
        map = mapValue;
    }

    @Override
    public final boolean makeValidation(Object object) {
        if (!(object instanceof Map)) {
            return false;
        }
        Map data = (Map) object;
        for (Map.Entry<String, BaseSchema> item: map.entrySet()) {
            String key = item.getKey();
            if (data.containsKey(key) && !(item.getValue().isValid(data.get(key)))) {
                return false;
            }
        }
        return true;
    }

}

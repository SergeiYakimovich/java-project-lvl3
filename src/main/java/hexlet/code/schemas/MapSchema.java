package hexlet.code.schemas;

import hexlet.code.Validation;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public final MapSchema sizeof(int size) {
        Predicate<Map> func = x -> x.size() == size;
        setValidationList(new Validation(func, Map.class));
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> map) {
        Predicate<Map> func = x -> shapeValidator(x, map);
        setValidationList(new Validation(func, Map.class));
        return this;
    }

    public final boolean shapeValidator(Map<String, BaseSchema> data, Map<String, BaseSchema> map) {
        for (Map.Entry<String, BaseSchema> item: map.entrySet()) {
            String key = item.getKey();
            if (data.containsKey(key) && !(item.getValue().isValid(data.get(key)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final MapSchema required() {
        Predicate<Map> func = x -> true;
        setValidationList(new Validation(func, Map.class));
        setRequiredOn(true);
        return this;
    }

}

package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema(Class requiredClassValue) {
        super(requiredClassValue);
    }

    public final MapSchema sizeof(int size) {
        Predicate<Map> func = x -> x.size() == size;
        addValidationList(func);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> map) {
        Predicate<Map> func = x -> shapeValidator(x, map);
        addValidationList(func);
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
        setRequiredOn(true);
        return this;
    }

}

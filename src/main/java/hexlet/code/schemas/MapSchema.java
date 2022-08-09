package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private boolean isSizeOn = false;
    private boolean isShapeOn = false;
    private int size;
    private Map<String, BaseSchema> map;

    @Override
    public final boolean isValid(Object object) {
        if (!isValidationOn()) {
            return true;
        }
        if (object == null) {
            return isRequiredOn() ? false : true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        Map data = (Map) object;
        return sizeValidation(data) && shapeValidation(data);
    }

    public final MapSchema sizeof(int sizeValue) {
        setValidationOn(true);
        isSizeOn = true;
        this.size = sizeValue;
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> mapValue) {
        setValidationOn(true);
        isShapeOn = true;
        map = mapValue;
        return this;
    }
    @Override
    public final MapSchema required() {
        setValidationOn(true);
        setRequiredOn(true);
        return this;
    }

    private boolean sizeValidation(Map data) {
        if (isSizeOn) {
            return data.size() == this.size;
        } else {
            return true;
        }
    }

    private boolean shapeValidation(Map data) {
        if (isShapeOn) {
            for (Map.Entry<String, BaseSchema> item: map.entrySet()) {
                String key = item.getKey();
                if (data.containsKey(key) && !(item.getValue().isValid(data.get(key)))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

}

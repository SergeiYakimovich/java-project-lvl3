package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public static final int VALIDATION_SIZE = 7;
    public static final int VALIDATION_SHAPE = 8;

    private int size;
    private Map<String, BaseSchema> map;

    @Override
    public final boolean isValid(Object object) {
        if (!(object instanceof Map) && object != null) {
            return false;
        }
        Map data = (Map) object;
        switch (getValidationType()) {
            case VALIDATION_TURNED_OFF:
                return true;
            case VALIDATION_REQUIRED:
                return data != null;
            case VALIDATION_SIZE:
                return data != null && data.size() == this.size;
            case VALIDATION_SHAPE:
                if (data == null) {
                    return false;
                }
                for (Map.Entry<String, BaseSchema> item: map.entrySet()) {
                    String key = item.getKey();
                    if (data.containsKey(key) && !(item.getValue().isValid(data.get(key)))) {
                        return false;
                    }
                }
                return true;
            default:
                return true;
        }
    }

    public final void sizeof(int sizeValue) {
        setValidationType(VALIDATION_SIZE);
        this.size = sizeValue;
    }

    public final void shape(Map<String, BaseSchema> mapValue) {
        setValidationType(VALIDATION_SHAPE);
        this.map = mapValue;
    }
}

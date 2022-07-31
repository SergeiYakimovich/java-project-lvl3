package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public static final int VALIDATION_SIZE = 7;
    private int size;

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
            default:
                return true;
        }
    }

    public final void sizeof(int sizeValue) {
        setValidationType(VALIDATION_SIZE);
        this.size = sizeValue;
    }


}

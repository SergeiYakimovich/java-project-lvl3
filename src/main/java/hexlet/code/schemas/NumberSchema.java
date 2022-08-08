package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public static final int VALIDATION_POSITIVE = 5;
    public static final int VALIDATION_RANGE = 6;
    private int min;
    private int max;

    @Override
    public final boolean isValid(Object object) {
        if (getValidationType() == VALIDATION_TURNED_OFF) {
            return true;
        }
        if (object == null) {
            return isRequired() ? false : true;
        }
        if (!(object instanceof Integer)) {
            return false;
        }
        int number = (int) object;
        switch (getValidationType()) {
            case VALIDATION_REQUIRED:
                return true;
            case VALIDATION_POSITIVE:
                return number > 0;
            case VALIDATION_RANGE:
                return number >= min && number <= max;
            default:
                return true;
        }
    }

    public final NumberSchema positive() {
        setValidationType(VALIDATION_POSITIVE);
        return this;
    }

    public final NumberSchema range(int minValue, int maxValue) {
        setValidationType(VALIDATION_RANGE);
        this.min = minValue;
        this.max = maxValue;
        return this;
    }

    @Override
    public final NumberSchema required() {
        setValidationType(VALIDATION_REQUIRED);
        setRequired(true);
        return this;
    }

}

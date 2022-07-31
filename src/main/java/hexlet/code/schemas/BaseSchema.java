package hexlet.code.schemas;

public abstract class BaseSchema {
    public static final int VALIDATION_TURNED_OFF = 1;
    public static final int VALIDATION_REQUIRED = 2;
    private int validationType = VALIDATION_TURNED_OFF;

    public abstract boolean isValid(Object object);

    public final void required() {
        validationType = VALIDATION_REQUIRED;
    }

    public final int getValidationType() {
        return validationType;
    }

    public final void setValidationType(int validationTypeValue) {
        validationType = validationTypeValue;
    }

}

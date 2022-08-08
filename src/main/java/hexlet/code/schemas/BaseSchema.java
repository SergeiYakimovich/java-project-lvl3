package hexlet.code.schemas;

public abstract class BaseSchema {
    public static final int VALIDATION_TURNED_OFF = 1;
    public static final int VALIDATION_REQUIRED = 2;
    private int validationType = VALIDATION_TURNED_OFF;
    private boolean isRequired = false;

    public abstract boolean isValid(Object object);

    public abstract BaseSchema required();

    public final int getValidationType() {
        return validationType;
    }

    public final void setValidationType(int validationTypeValue) {
        validationType = validationTypeValue;
    }

    public final boolean isRequired() {
        return isRequired;
    }

    public final void setRequired(boolean requiredValue) {
        isRequired = requiredValue;
    }

}

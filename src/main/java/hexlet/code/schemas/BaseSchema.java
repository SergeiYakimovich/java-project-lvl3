package hexlet.code.schemas;

public abstract class BaseSchema {
    private boolean isValidationOn = false;
    private boolean isRequiredOn = false;

    public abstract boolean isValid(Object object);

    public abstract BaseSchema required();

    public final boolean isRequiredOn() {
        return isRequiredOn;
    }

    public final void setRequiredOn(boolean requiredValue) {
        isRequiredOn = requiredValue;
    }

    public final boolean isValidationOn() {
        return isValidationOn;
    }

    public final void setValidationOn(boolean validationValue) {
        isValidationOn = validationValue;
    }

}

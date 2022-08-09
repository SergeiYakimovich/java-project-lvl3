package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean isPositiveOn = false;
    private boolean isRangeOn = false;
    private int min;
    private int max;

    @Override
    public final boolean isValid(Object object) {
        if (!isValidationOn()) {
            return true;
        }
        if (object == null) {
            return isRequiredOn() ? false : true;
        }
        if (!(object instanceof Integer)) {
            return false;
        }
        int number = (int) object;
        return rangeValidation(number) && positiveValidation(number);
    }

    public final NumberSchema positive() {
        setValidationOn(true);
        isPositiveOn = true;
        return this;
    }

    public final NumberSchema range(int minValue, int maxValue) {
        setValidationOn(true);
        isRangeOn = true;
        min = minValue;
        max = maxValue;
        return this;
    }

    @Override
    public final NumberSchema required() {
        setValidationOn(true);
        setRequiredOn(true);
        return this;
    }

    private boolean rangeValidation(int number) {
        if (isRangeOn) {
            return number >= min && number <= max;
        } else {
            return true;
        }
    }

    private boolean positiveValidation(int number) {
        if (isPositiveOn) {
            return number > 0;
        } else {
            return true;
        }
    }

}

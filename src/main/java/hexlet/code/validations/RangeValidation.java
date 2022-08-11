package hexlet.code.validations;

public class RangeValidation extends Validation {
    private int min;
    private int max;

    public RangeValidation(int minValue, int maxValue) {
        min = minValue;
        max = maxValue;
    }

    @Override
    public final boolean makeValidation(Object object) {
        if (!(object instanceof Integer)) {
            return false;
        }
        int number = (int) object;
        return number >= min && number <= max;
    }

}

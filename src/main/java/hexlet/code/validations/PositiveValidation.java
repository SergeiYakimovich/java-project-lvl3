package hexlet.code.validations;

public class PositiveValidation extends Validation {
    @Override
    public final boolean makeValidation(Object object) {
        if (!(object instanceof Integer)) {
            return false;
        }
        int number = (int) object;
        return number > 0;
    }

}

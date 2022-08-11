package hexlet.code.validations;

public class MinLengthValidation extends Validation {
    private int length;

    public MinLengthValidation(int lengthValue) {
        length = lengthValue;
    }

    @Override
    public final boolean makeValidation(Object object) {
        if (!(object instanceof String)) {
            return false;
        }
        String str = (String) object;
        return str.length() >= length;
    }

}

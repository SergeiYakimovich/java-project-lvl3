package hexlet.code.validations;

public class ContainsValidation extends Validation {
    private String subStr;

    public ContainsValidation(String subStrValue) {
        subStr = subStrValue;
    }

    @Override
    public final boolean makeValidation(Object object) {
        if (!(object instanceof String)) {
            return false;
        }
        String str = (String) object;
        return str.contains(subStr);
    }

}

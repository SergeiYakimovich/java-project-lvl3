package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private boolean isMinLengthOn = false;
    private boolean isContainsOn = false;
    private int length;
    private String subStr;

    @Override
    public final boolean isValid(Object object) {
        if (!isValidationOn()) {
            return true;
        }
        if (object == null) {
            return isRequiredOn() ? false : true;
        }
        if (!(object instanceof String)) {
            return false;
        }
        String str = (String) object;
        return requiredValidation(str) && containsValidation(str) && minLengthValidation(str);
    }

    @Override
    public final StringSchema required() {
        setValidationOn(true);
        setRequiredOn(true);
        return this;
    }
    public final StringSchema contains(String subStrValue) {
        setValidationOn(true);
        isContainsOn = true;
        subStr = subStrValue;
        return this;
    }

    public final StringSchema minLength(int lengthValue) {
        setValidationOn(true);
        isMinLengthOn = true;
        this.length = lengthValue;
        return this;
    }

    private boolean requiredValidation(String str) {
        if (isRequiredOn()) {
            return str.length() != 0;
        } else {
            return true;
        }
    }

    private boolean containsValidation(String str) {
        if (isContainsOn) {
            return str.contains(subStr);
        } else {
            return true;
        }
    }

    private boolean minLengthValidation(String str) {
        if (isMinLengthOn) {
            return str.length() >= length;
        } else {
            return true;
        }
    }

}

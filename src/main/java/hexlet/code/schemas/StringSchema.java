package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    public static final int VALIDATION_MIN_LENGTH = 3;
    public static final int VALIDATION_CONTAINS = 4;
    private int length;
    private String subStr;

    @Override
    public final boolean isValid(Object object) {
        if (!(object instanceof String) && object != null) {
            return false;
        }
        String str = (String) object;
        switch (getValidationType()) {
            case VALIDATION_TURNED_OFF:
                return true;
            case VALIDATION_REQUIRED:
                return str != null && str.length() != 0;
            case VALIDATION_MIN_LENGTH:
                return str != null && str.length() >= this.length;
            case VALIDATION_CONTAINS:
                return str != null && str.contains(this.subStr);
            default:
                return true;
        }
    }

    public final StringSchema contains(String subStrValue) {
        setValidationType(VALIDATION_CONTAINS);
        this.subStr = subStrValue;
        return this;
    }

    public final StringSchema minLength(int lengthValue) {
        setValidationType(VALIDATION_MIN_LENGTH);
        this.length = lengthValue;
        return this;
    }

}

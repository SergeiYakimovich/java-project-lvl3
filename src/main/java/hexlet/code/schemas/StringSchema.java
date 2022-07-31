package hexlet.code.schemas;

public final class StringSchema {
    private int length;
    private String subStr;

    private ValidationTypes validationType = ValidationTypes.turnedOff;

    public enum ValidationTypes {
        turnedOff,
        required,
        minLength,
        contains;
    }
    public boolean isValid(String str) {
        switch (this.validationType) {
            case turnedOff:
                return true;
            case required:
                return str != null && str.length() != 0;
            case minLength:
                return str != null && str.length() >= this.length;
            case contains:
                return str != null && str.contains(this.subStr);
            default:
                return true;
        }
    }

    public void required() {
        this.validationType = ValidationTypes.required;
    }

    public void contains(String subStrValue) {
        this.validationType = ValidationTypes.contains;
        this.subStr = subStrValue;
    }
    public void minLength(int lengthValue) {
        this.validationType = ValidationTypes.minLength;
        this.length = lengthValue;
    }

}

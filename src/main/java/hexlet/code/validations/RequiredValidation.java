package hexlet.code.validations;

public class RequiredValidation extends Validation {
    private Class requiredClass;

    public RequiredValidation(Class requiredClassValue) {
        requiredClass = requiredClassValue;
    }

    @Override
    public final boolean makeValidation(Object object) {
        if (!requiredClass.isInstance(object)) {
            return false;
        }
        if (object instanceof String) {
            String str = (String) object;
            return str.length() != 0;
        }
        return true;
    }

}

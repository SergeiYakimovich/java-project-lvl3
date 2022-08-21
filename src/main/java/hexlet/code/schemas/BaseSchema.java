package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private boolean isRequiredOn = false;
    private Class requiredClass;
    private List<Predicate> validationList = new ArrayList<>();

    public final boolean isValid(Object object) {
        if (validationList.size() == 0 && !isRequiredOn) {
            return true;
        }
        if (object == null) {
            return isRequiredOn ? false : true;
        }
        if (!requiredClass.isInstance(object)) {
            return false;
        }
        for (Predicate item : validationList) {
            if (!item.test(object)) {
                return false;
            }
        }
        return true;
    }

    public abstract BaseSchema required();

    public BaseSchema(Class requiredClassValue) {
        requiredClass = requiredClassValue;
    }

    protected final void addValidationList(Predicate validationValue) {
        validationList.add(validationValue);
    }
    protected final void setRequiredOn(boolean requiredValue) {
        isRequiredOn = requiredValue;
    }

}

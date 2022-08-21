package hexlet.code.schemas;

import hexlet.code.Validation;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSchema {
    private boolean isRequiredOn = false;
    public Class requiredClass;
    private List<Validation> validationList = new ArrayList<>();

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
        for (Validation item : validationList) {
            if (!item.makeValidation(object)) {
                return false;
            }
        }
        return true;
    }

    public abstract BaseSchema required();

//    public BaseSchema(Class requiredClassValue) {
//        requiredClass = requiredClassValue;
//    }

    protected final void addValidationList(Validation validationValue) {
        validationList.add(validationValue);
    }
    protected final void setRequiredOn(boolean requiredValue) {
        isRequiredOn = requiredValue;
    }

//    protected final void setRequiredClass(Class requiredClassValue) {
//        requiredClass = requiredClassValue;
//    }

}

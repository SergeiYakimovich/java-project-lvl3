package hexlet.code.schemas;

import hexlet.code.Validation;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSchema {
    private boolean isRequiredOn = false;
    private List<Validation> validationList = new ArrayList<>();

    public final boolean isValid(Object object) {
        if (validationList.size() == 0) {
            return true;
        }
        if (!isRequiredOn && object == null) {
            return true;
        }
        for (Validation item : validationList) {
            if (!item.makeValidation(object)) {
                return false;
            }
        }
        return true;
    }

    public abstract BaseSchema required();

    protected final void setValidationList(Validation validationValue) {
        validationList.add(validationValue);
    }
    protected final void setRequiredOn(boolean requiredValue) {
        isRequiredOn = requiredValue;
    }

}

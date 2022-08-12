package hexlet.code;

import java.util.function.Predicate;

public class Validation<T> {
    private Predicate<T> func;
    private Class requiredClass;

    public Validation(Predicate<T> funcValue, Class requiredClassValue) {
        func = funcValue;
        requiredClass = requiredClassValue;
    }

    public final boolean makeValidation(Object object) {
        if (!requiredClass.isInstance(object)) {
            return false;
        }
        T modifiedObject = (T) object;
        return func.test(modifiedObject);
    }

}

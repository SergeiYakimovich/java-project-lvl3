package hexlet.code;

import java.util.function.Predicate;

public class Validation<T> {
    private Predicate<T> func;

    public Validation(Predicate<T> funcValue) {
        func = funcValue;
    }

    public final boolean makeValidation(Object object) {
        T modifiedObject = (T) object;
        return func.test(modifiedObject);
    }

}

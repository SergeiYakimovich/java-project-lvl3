package hexlet.code.validations;

import java.util.Map;

public class SizeValidation extends Validation {
    private int size;

    public SizeValidation(int sizeValue) {
        size = sizeValue;
    }

    @Override
    public final boolean makeValidation(Object object) {
        if (!(object instanceof Map)) {
            return false;
        }
        Map data = (Map) object;
        return data.size() == this.size;
    }

}

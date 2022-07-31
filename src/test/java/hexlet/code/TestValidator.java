package hexlet.code;

import org.junit.jupiter.api.Test;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
//import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.junit.platform.engine.TestTag.isValid;

public class TestValidator {
    public static final int TEN = 10;
    public static final int MINUS_TEN = -10;
    public static final int FIVE = 5;

    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isEqualTo(true);
        assertThat(schema.isValid(null)).isEqualTo(true);

        schema.required();
        assertThat(schema.isValid("what does the fox say")).isEqualTo(true);
        assertThat(schema.isValid("hexlet")).isEqualTo(true);
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid("")).isEqualTo(false);

        schema.contains("wh");
        assertThat(schema.isValid("what does the fox say")).isEqualTo(true);
        schema.contains("what");
        assertThat(schema.isValid("what does the fox say")).isEqualTo(true);
        schema.contains("whatthe");
        assertThat(schema.isValid("what does the fox say")).isEqualTo(false);
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid("")).isEqualTo(false);

        schema.minLength(2);
        assertThat(schema.isValid("what does the fox say")).isEqualTo(true);
        assertThat(schema.isValid("h")).isEqualTo(false);
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid("")).isEqualTo(false);

    }

    @Test
    public void testNumberSchema() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertThat(schema.isValid(null)).isEqualTo(true);

        schema.required();
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid(TEN)).isEqualTo(true);
        assertThat(schema.isValid("5")).isEqualTo(false);

        schema.positive();
        assertThat(schema.isValid(TEN)).isEqualTo(true);
        assertThat(schema.isValid(MINUS_TEN)).isEqualTo(false);

        schema.range(FIVE, TEN);
        assertThat(schema.isValid(FIVE)).isEqualTo(true);
        assertThat(schema.isValid(TEN)).isEqualTo(true);
        assertThat(schema.isValid(FIVE - 1)).isEqualTo(false);
        assertThat(schema.isValid(TEN + 1)).isEqualTo(false);

    }

    @Test
    public void testMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isEqualTo(true);

        schema.required();
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid(new HashMap())).isEqualTo(true);
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isEqualTo(true);

        schema.sizeof(2);
        assertThat(schema.isValid(data)).isEqualTo(false);
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isEqualTo(true);

    }


}

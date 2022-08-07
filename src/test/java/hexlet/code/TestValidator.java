package hexlet.code;

import org.junit.jupiter.api.Test;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class TestValidator {
    public static final int TEN = 10;
    public static final int FIVE = 5;
    public static final int HUNDRED = 100;

    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("abc")).isEqualTo(true);
        assertThat(schema.isValid("")).isEqualTo(true);
        assertThat(schema.isValid(null)).isEqualTo(true);

        schema.required();
        assertThat(schema.isValid("abc")).isEqualTo(true);
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
        assertThat(schema.isValid(-TEN)).isEqualTo(false);

        schema.range(FIVE, TEN);
        assertThat(schema.isValid(FIVE)).isEqualTo(true);
        assertThat(schema.isValid(FIVE + 1)).isEqualTo(true);
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

    @Test
    public void testMapSchemaShape() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        StringSchema schemaStr = v.string();
        schemaStr.required();
        schemas.put("name", schemaStr);
        NumberSchema schemaNum = v.number();
        schemaNum.positive();
        schemas.put("age", schemaNum);
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", HUNDRED);
        assertThat(schema.isValid(human1)).isEqualTo(true);

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isEqualTo(false);

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isEqualTo(false);

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -FIVE);
        assertThat(schema.isValid(human4)).isEqualTo(false);
    }

}

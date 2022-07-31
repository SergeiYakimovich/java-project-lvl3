package hexlet.code;

import org.junit.jupiter.api.Test;
import hexlet.code.schemas.StringSchema;
//import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

//import static org.junit.platform.engine.TestTag.isValid;

public class TestValidator {

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

}

package annotations;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class BeanNamingTest {

    private static GenericXmlApplicationContext ctx;

    @BeforeAll
    static void setup() {
        ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-01.xml");
        ctx.refresh();
    }

    @AfterAll
    static void free_resources() {
        ctx.close();
    }

    @Test
    public void beans_naming_test() {
        Map<String,String> beans = ctx.getBeansOfType(String.class);
        Assertions.assertTrue(beans.size() == 3);
        Assertions.assertArrayEquals(new String[]{"string1", "string2", "java.lang.String#0"},
                                    beans.keySet().toArray());
    }
}

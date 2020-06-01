package annotations;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNamingTest {

    private static GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

    @BeforeAll
    static void setup() {
        ctx.load("app-context-01.xml");
        ctx.refresh();
    }

    @AfterAll
    static void free_resources() {
        ctx.close();
    }

    @Test
    public void beans_naming_test() {
        System.out.println("hola mundo");
    }
}

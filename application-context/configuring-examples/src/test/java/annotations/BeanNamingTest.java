package annotations;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class BeanNamingTest {

    @Test
    public void beans_naming_test() {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-01.xml");
        ctx.refresh();

        Map<String,String> beans = ctx.getBeansOfType(String.class);
        Assertions.assertTrue(beans.size() == 3);
        Assertions.assertArrayEquals(new String[]{"string1", "string2", "java.lang.String#0"},
                                    beans.keySet().toArray());

        ctx.close();
    }

    @Test
    public void beans_name_aliasing_test() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-02.xml");
        ctx.refresh();

        Map<String,String> beans = ctx.getBeansOfType(String.class);

        String s1 = (String) ctx.getBean("john");
        String s2 = (String) ctx.getBean("jon");
        String s3 = (String) ctx.getBean("johnny");
        String s4 = (String) ctx.getBean("jonathan");
        String s5 = (String) ctx.getBean("jim");
        String s6 = (String) ctx.getBean("ion");

        Assertions.assertAll(
                () -> Assertions.assertSame(s1, s2),
                () -> Assertions.assertSame(s2, s3),
                () -> Assertions.assertSame(s3, s4),
                () -> Assertions.assertSame(s4, s5),
                () -> Assertions.assertSame(s5, s6),
                () -> Assertions.assertTrue(beans.size() == 1));

        ctx.close();
    }
}
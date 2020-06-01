package annotations;

import com.gonzajf.spring.ch3.annotation.Singer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class FieldInjectionTest {

    private static GenericXmlApplicationContext xmlApplicationContext;

    @BeforeAll
    static void setup() {
        xmlApplicationContext =
                new GenericXmlApplicationContext();
        xmlApplicationContext.load("app-context-annotation.xml");
        xmlApplicationContext.refresh();

    }

    @AfterAll
    static void free_resources() {
        xmlApplicationContext.close();
    }

    @Test
    public void singer_lyrics_test() {

        Singer singerBean = xmlApplicationContext.getBean(Singer.class);
        Assertions.assertEquals("For all my running, I can understand",
                                singerBean.sing());
    }

}
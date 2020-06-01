package annotations;

import com.gonzajf.spring.ch3.annotation.configurationClass.HelloWorldConfiguration;
import com.gonzajf.spring.helloWorld.decoupled.MessageRenderer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclaringSpringComponentsTest {

    private static GenericXmlApplicationContext xmlApplicationContext;
    private static ApplicationContext applicationContext;

    @BeforeAll
    static void setup() {
        xmlApplicationContext =
                new GenericXmlApplicationContext();
        xmlApplicationContext.load("app-context-xml.xml");
        xmlApplicationContext.refresh();

        applicationContext =
                new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    }

    @AfterAll
    static void free_resources() {
        xmlApplicationContext.close();
    }

    @Test
    public void context_from_xml() {
        Assertions.assertTrue(xmlApplicationContext instanceof GenericXmlApplicationContext);
        MessageRenderer messageRenderer =
                xmlApplicationContext.getBean("renderer", MessageRenderer.class);
        Assertions.assertNotNull(messageRenderer.getMessageProvider());
        messageRenderer.render();
    }

    @Test
    public void contest_from_configurationClass() {
        Assertions.assertTrue(applicationContext instanceof AnnotationConfigApplicationContext);
        MessageRenderer messageRenderer =
                applicationContext.getBean("renderer", MessageRenderer.class);
        Assertions.assertNotNull(messageRenderer.getMessageProvider());
        messageRenderer.render();
    }
}
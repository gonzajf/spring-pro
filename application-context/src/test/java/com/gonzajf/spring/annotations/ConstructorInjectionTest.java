package com.gonzajf.spring.annotations;

import com.gonzajf.spring.annotation.configurationClass.HelloWorldConfiguration;
import com.gonzajf.spring.helloWorld.decoupled.MessageProvider;
import com.gonzajf.spring.helloWorld.decoupled.MessageRenderer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConstructorInjectionTest {

    private static GenericXmlApplicationContext xmlApplicationContext;
    private static ApplicationContext applicationContext;

    @BeforeAll
    static void setup() {
        xmlApplicationContext =
                new GenericXmlApplicationContext();
        xmlApplicationContext.load("app-context-constructor-injection.xml");
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
        MessageProvider provider =
                xmlApplicationContext.getBean("provider", MessageProvider.class);
        Assertions.assertEquals(
                "I hope that someone gets my message in a bottle",
                provider.getMessage());
    }

    @Test
    public void contest_from_configurationClass() {
        MessageProvider provider =
                applicationContext.getBean("constructor injection provider", MessageProvider.class);
        Assertions.assertEquals(
                "Configurable Message",
                provider.getMessage());
    }

}

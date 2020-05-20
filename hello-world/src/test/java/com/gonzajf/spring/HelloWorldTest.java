package com.gonzajf.spring;

import com.gonzajf.spring.helloWorld.HelloWorldConfiguration;
import com.gonzajf.spring.helloWorld.decoupled.MessageRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

    private static ApplicationContext contextFromXml;
    private static ApplicationContext contextFromConfigurationClass;

    @BeforeAll
    static void setup() {
        contextFromXml =
                new ClassPathXmlApplicationContext("spring/app-context.xml");
         contextFromConfigurationClass =
                new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    }

    @Test
    public void context_from_xml(){

        Assertions.assertTrue(contextFromXml instanceof ClassPathXmlApplicationContext);
        MessageRenderer renderer =
                contextFromXml.getBean("renderer", MessageRenderer.class);
        Assertions.assertNotNull(renderer.getMessageProvider());
        renderer.render();
    }

    @Test
    public void context_from_classConfiguration(){

        Assertions.assertTrue(contextFromConfigurationClass instanceof AnnotationConfigApplicationContext);
        MessageRenderer renderer =
                contextFromConfigurationClass.getBean("renderer", MessageRenderer.class);
        Assertions.assertNotNull(renderer.getMessageProvider());
        renderer.render();
    }
}
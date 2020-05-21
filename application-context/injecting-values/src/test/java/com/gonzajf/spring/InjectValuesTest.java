package com.gonzajf.spring;

import com.gonzajf.spring.xml.InjectSimple;
import com.gonzajf.spring.xml.InjectSimpleSpel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectValuesTest {

    private static GenericXmlApplicationContext ctxXml;
    private static GenericXmlApplicationContext ctxAnnotated;

    @BeforeAll
    static void setUp() {
        ctxXml = new GenericXmlApplicationContext();
        ctxXml.load("app-context-xml.xml");
        ctxXml.refresh();

        ctxAnnotated = new GenericXmlApplicationContext();
        ctxAnnotated.load("app-context-annotation.xml");
        ctxAnnotated.refresh();
    }

    @AfterAll
    static void release() {
        ctxXml.close();
        ctxAnnotated.close();
    }

    @Test
    public void inject_simple_values() {
        InjectSimple simple = ctxXml.getBean(InjectSimple.class);
        Assertions.assertEquals("John Mayer", simple.getName());
        Assertions.assertEquals(39, simple.getAge());
        Assertions.assertFalse(simple.isProgrammer());
        Assertions.assertEquals(1241401112, simple.getAgeInSeconds());
    }

    @Test
    public void inject_spEl_values() {
        InjectSimpleSpel simple = ctxXml.getBean(InjectSimpleSpel.class);
        Assertions.assertEquals("John Mayer", simple.getName());
        Assertions.assertEquals(40, simple.getAge());
        Assertions.assertFalse(simple.isProgrammer());
        Assertions.assertEquals(1241401112, simple.getAgeInSeconds());
    }

    @Test
    public void inject_spEl_values_annotated() {
        com.gonzajf.spring.annotation.InjectSimpleSpel simple =
                ctxAnnotated.getBean(com.gonzajf.spring.annotation.InjectSimpleSpel.class);
        Assertions.assertEquals("John Mayer", simple.getName());
        Assertions.assertEquals(40, simple.getAge());
        Assertions.assertFalse(simple.isProgrammer());
        Assertions.assertEquals(1241401112, simple.getAgeInSeconds());
    }
}

package com.gonzajf.spring;

import com.gonzajf.spring.xml.InjectSimple;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleTest {

    private static GenericXmlApplicationContext ctx;

    @BeforeAll
    static void setUp() {
        ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml.xml");
        ctx.refresh();
    }

    @AfterAll
    static void release() {
        ctx.close();
    }


    @Test
    public void inject_values() {
        InjectSimple simple = ctx.getBean(InjectSimple.class);
        Assertions.assertEquals("John Mayer", simple.getName());
        Assertions.assertEquals(39, simple.getAge());
        Assertions.assertFalse(simple.isProgrammer());
        Assertions.assertEquals(1241401112, simple.getAgeInSeconds());
    }
}

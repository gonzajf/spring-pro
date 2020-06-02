package com.gonzajf.spring.ch4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JSR250AnnotationTest {

    private static GenericXmlApplicationContext ctx;

    @BeforeAll
    private static void setUp() {
        ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-annotation.xml");
        ctx.refresh();
    }

    @AfterAll
    private static void free() {
        ctx.close();
    }

    @Test
    public void bean_created_correctly_with_all_attributes_as_parameters() {
        SingerWithJSR250 singer = getBean("singerOne", ctx);
        Assertions.assertAll(
                () -> Assertions.assertEquals("John Mayer", singer.getName()),
                () -> Assertions.assertEquals(39, singer.getAge())
        );
    }

    @Test
    public void bean_created_correctly_with_default_name() {
        SingerWithJSR250 singer = getBean("singerTwo", ctx);
        Assertions.assertAll(
                () -> Assertions.assertEquals("Eric Clapton", singer.getName()),
                () -> Assertions.assertEquals(72, singer.getAge())
        );
    }

    @Test
    public void bean_created_correctly_with_error_throws_exception() {
        Assertions.assertEquals(null, getBean("singerThree", ctx));
    }

    public static SingerWithJSR250 getBean(String beanName, ApplicationContext ctx)  {
        try {
            SingerWithJSR250 bean = (SingerWithJSR250) ctx.getBean(beanName);
            System.out.println(bean);
            return  bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    +  ex.getMessage());
            return null;
        }
    }
}

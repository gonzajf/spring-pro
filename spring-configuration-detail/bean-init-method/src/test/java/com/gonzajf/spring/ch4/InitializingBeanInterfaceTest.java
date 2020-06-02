package com.gonzajf.spring.ch4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InitializingBeanInterfaceTest {

    private static GenericXmlApplicationContext ctx;

    @BeforeAll
    private static void setUp() {
        ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml.xml");
        ctx.refresh();
    }

    @AfterAll
    private static void free() {
        ctx.close();
    }

    @Test
    public void bean_created_correctly_with_all_attributes_as_parameters() {
        SingerWithInterface singer = getBean("singerWithInterfaceOne", ctx);
        Assertions.assertAll(
                () -> Assertions.assertEquals("John Mayer", singer.getName()),
                () -> Assertions.assertEquals(39, singer.getAge())
        );
    }

    @Test
    public void bean_created_correctly_with_default_name() {
        SingerWithInterface singer = getBean("singerWithInterfaceTwo", ctx);
        Assertions.assertAll(
                () -> Assertions.assertEquals("Eric Clapton", singer.getName()),
                () -> Assertions.assertEquals(72, singer.getAge())
        );
    }

    @Test
    public void bean_created_correctly_with_error_throws_exception() {
        Assertions.assertEquals(null, getBean("singerWithInterfaceThree", ctx));
    }

    public static SingerWithInterface getBean(String beanName, ApplicationContext ctx)  {
        try {
            SingerWithInterface bean = (SingerWithInterface) ctx.getBean(beanName);
            System.out.println(bean);
            return  bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    +  ex.getMessage());
            return null;
        }
    }

}

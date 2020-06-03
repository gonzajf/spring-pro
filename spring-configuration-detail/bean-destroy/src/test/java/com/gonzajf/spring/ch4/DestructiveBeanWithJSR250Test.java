package com.gonzajf.spring.ch4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBeanWithJSR250Test {

    private static GenericXmlApplicationContext ctx;
    private static DestructiveBeanWithJSR250 bean;
    private static File file;

    @BeforeEach
    public void setUp() {
        ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-annotation.xml");
        ctx.refresh();
        bean = (DestructiveBeanWithJSR250) ctx.getBean("destructiveBeanWithJSR250");
    }

    @Test
    @Order(1)
    public void file_exists_test() {
        Assertions.assertTrue(bean.getFile().exists());
    }

    @Test
    @Order(2)
    public void file_is_deleted_on_destroy_test() {
        file = bean.getFile();
        ctx.destroy();
        Assertions.assertFalse(file.exists());
    }
}
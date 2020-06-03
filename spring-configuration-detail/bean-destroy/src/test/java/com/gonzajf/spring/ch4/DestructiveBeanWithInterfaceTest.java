package com.gonzajf.spring.ch4;

import org.junit.jupiter.api.*;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBeanWithInterfaceTest {

    private static GenericXmlApplicationContext ctx;
    private static DestructiveBeanWithInterface bean;
    private static File file;

    @BeforeEach
    public void setUp() {
        ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml.xml");
        ctx.refresh();
        bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBeanWithInterface");
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

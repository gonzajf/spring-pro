package com.gonzajf.spring.ch4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanAwareInterfaceTest {

    @Test
    public void interface_test() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml.xml");
        ctx.refresh();
        NamedSinger bean = (NamedSinger) ctx.getBean("johnMayer");

        Assertions.assertEquals("johnMayer", bean.getName());

        ctx.close();
    }
}

package com.gonzajf.spring.ch3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MethodInjectionTest {

    private static GenericXmlApplicationContext ctx;
    private static DemoBean abstractBean;
    private static DemoBean standardBean;
    private static Singer singer1;
    private static Singer singer2;

    @BeforeAll
    public static void setUp() {
        ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml.xml");
        ctx.refresh();
        abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
        standardBean = ctx.getBean("standardLookupBean", DemoBean.class);
    }

    @AfterAll
    static void release() {
        ctx.close();
    }

    @Test
    public void abstract_bean_test() {
        Singer singer = abstractBean.getSinger();
        singer1 = abstractBean.getSinger();

        Assertions.assertNotSame(singer1, singer);
    }

    @Test
    public void standard_bean_test() {
        Singer singer = standardBean.getSinger();
        singer2 = standardBean.getSinger();

        Assertions.assertSame(singer2, singer);
    }
}
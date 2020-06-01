package com.gonzajf.spring.ch3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MethodReplacementTest {

    private static GenericXmlApplicationContext ctx;
    private static ReplacementTarget replacementTarget;
    private static ReplacementTarget standardTarget;

    @BeforeAll
    public static void setUp() {
        ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml.xml");
        ctx.refresh();
    }

    @AfterAll
    static void release() {
        ctx.close();
    }

    @Test
    public void standard_target_test() {
        standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");

        Assertions.assertEquals("<h1>Thanks for playing, try again!</h1>",
                standardTarget.formatMessage("Thanks for playing, try again!"));
    }

    @Test
    public void replacement_target_test() {
        replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");

        Assertions.assertEquals("<h2>Thanks for playing, try again!</h2>",
                replacementTarget.formatMessage("Thanks for playing, try again!"));
    }
}
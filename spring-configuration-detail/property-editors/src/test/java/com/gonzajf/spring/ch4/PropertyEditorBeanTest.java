package com.gonzajf.spring.ch4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.net.URL;
import java.util.Locale;

public class PropertyEditorBeanTest {

    @Test
    public void property_bean_test() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-config-01.xml");
        ctx.refresh();
        PropertyEditorBean bean = (PropertyEditorBean) ctx.getBean("builtInSample");

        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(new byte[]{74, 111, 104, 110, 32, 77, 97, 121, 101, 114},
                        bean.getBytes()),
                () -> Assertions.assertEquals('A', bean.getCharacter()),
                () -> Assertions.assertEquals(String.class, bean.getCls()),
                () -> Assertions.assertEquals("test.txt", bean.getFile().getName()),
                () -> Assertions.assertEquals(Locale.US, bean.getLocale()),
                () -> Assertions.assertEquals("a*b", bean.getPattern().pattern()),
                () -> Assertions.assertEquals(2, bean.getStringList().size()),
                () -> Assertions.assertEquals("String need trimming", bean.getTrimString()),
                () -> Assertions.assertTrue(bean.getTrueOrFalse()),
                () -> Assertions.assertEquals(new URL("https://spring.io/"), bean.getUrl())
        );

        ctx.close();
    }
}

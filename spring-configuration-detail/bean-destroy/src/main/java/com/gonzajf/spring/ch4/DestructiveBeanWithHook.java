package com.gonzajf.spring.ch4;

import com.gonzajf.spring.ch4.config.DestructiveBeanConfigDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class DestructiveBeanWithHook {

    public static void main(String... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(
                        DestructiveBeanConfigDemo.DestructiveBeanConfig.class);
        ctx.getBean(DestructiveBeanWithJSR250.class);
        ctx.registerShutdownHook();
    }
}
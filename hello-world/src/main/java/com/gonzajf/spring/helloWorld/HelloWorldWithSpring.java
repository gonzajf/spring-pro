package com.gonzajf.spring.helloWorld;

import com.gonzajf.spring.helloWorld.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldWithSpring {

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}

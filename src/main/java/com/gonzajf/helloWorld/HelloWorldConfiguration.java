package com.gonzajf.helloWorld;

import com.gonzajf.helloWorld.decoupled.HelloWorldMessageProvider;
import com.gonzajf.helloWorld.decoupled.MessageProvider;
import com.gonzajf.helloWorld.decoupled.MessageRenderer;
import com.gonzajf.helloWorld.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public MessageProvider provider(){
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
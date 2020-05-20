package com.gonzajf.spring.annotation;

import com.gonzajf.spring.helloWorld.decoupled.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    public String getMessage() {
        return "Hello World from Component";
    }
}

package com.gonzajf.spring.helloWorld.decoupled;

public class HelloWorldMessageProvider implements  MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World";
    }
}

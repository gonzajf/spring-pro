package com.gonzajf.spring.xml;

import com.gonzajf.spring.helloWorld.decoupled.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
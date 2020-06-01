package com.gonzajf.spring.ch3.annotation;

import com.gonzajf.spring.helloWorld.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("constructor injection provider")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    @Autowired
    public ConfigurableMessageProvider(@Value("Configurable Message") String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
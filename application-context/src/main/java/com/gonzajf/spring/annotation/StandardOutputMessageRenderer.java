package com.gonzajf.spring.annotation;

import com.gonzajf.spring.helloWorld.decoupled.MessageProvider;
import com.gonzajf.spring.helloWorld.decoupled.MessageRenderer;
import com.gonzajf.spring.helloWorld.decoupled.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("renderer")
public class StandardOutputMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    public void render() {
        if(messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:" +
                            StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Autowired
    public void setMessageProvider(MessageProvider provider) {
        messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
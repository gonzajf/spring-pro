package com.gonzajf.spring.helloWorld.decoupled;

public interface MessageRenderer {

    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}

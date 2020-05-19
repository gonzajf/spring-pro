package com.gonzajf.helloWorld.decoupled;

import com.gonzajf.helloWorld.decoupled.MessageProvider;

import java.text.MessageFormat;

public interface MessageRenderer {

    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}

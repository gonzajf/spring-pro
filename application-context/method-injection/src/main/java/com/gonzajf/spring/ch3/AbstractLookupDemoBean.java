package com.gonzajf.spring.ch3;

public abstract class AbstractLookupDemoBean implements DemoBean {

    public abstract Singer getSinger();

    @Override
    public void doSomething() {
        getSinger().sing();
    }
}
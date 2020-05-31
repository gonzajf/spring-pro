package com.gonzajf.spring.ch3;

public class StandardLookupDemoBean implements DemoBean {

    private Singer singer;

    public void setSinger(Singer mySinger) {
        singer = mySinger;
    }

    @Override
    public Singer getSinger() {
        return singer;
    }

    @Override
    public void doSomething() {
        singer.sing();
    }
}

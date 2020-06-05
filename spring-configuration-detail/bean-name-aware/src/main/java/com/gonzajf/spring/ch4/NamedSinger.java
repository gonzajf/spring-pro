package com.gonzajf.spring.ch4;

import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String beanName) {
        this.name = beanName;
    }

    public String getName() {
        return name;
    }
}
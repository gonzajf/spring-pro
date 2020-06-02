package com.gonzajf.spring.ch4;

import org.springframework.beans.factory.InitializingBean;

public class SingerWithInterface implements InitializingBean {

    private static final String DEFAULT_NAME = "Eric Clapton";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("Initializing bean");
        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if(age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " +  Singer.class);
        }
    }
}

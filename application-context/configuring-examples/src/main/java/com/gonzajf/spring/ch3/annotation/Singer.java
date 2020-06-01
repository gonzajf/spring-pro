package com.gonzajf.spring.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("singer")
public class Singer {

    @Autowired
    private Inspiration inspiration;

    public String sing() {
        return inspiration.getLyric();
    }

}

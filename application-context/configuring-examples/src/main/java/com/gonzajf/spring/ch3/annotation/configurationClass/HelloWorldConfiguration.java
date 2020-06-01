package com.gonzajf.spring.ch3.annotation.configurationClass;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.gonzajf.spring.ch3.annotation"})
@Configuration
public class HelloWorldConfiguration {

}
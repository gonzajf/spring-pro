package com.gonzajf.spring.annotation.configurationClass;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.gonzajf.spring.annotation"})
@Configuration
public class HelloWorldConfiguration {

}
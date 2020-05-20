package com.gonzajf.annotation.configurationClass;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.gonzajf.annotation"})
@Configuration
public class HelloWorldConfiguration {

}
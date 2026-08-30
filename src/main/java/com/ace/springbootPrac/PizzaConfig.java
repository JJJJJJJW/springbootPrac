package com.ace.springbootPrac;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pizza")
public class PizzaConfig {
    private String sauce;
    private String crust;
}

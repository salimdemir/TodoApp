package com.todo.todo.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "myserver")
public class MyServerConfiguration {

    int port;
    String url;
}

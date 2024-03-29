package com.todo.todo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        System.out.println("datasource url=" + System.getenv("spring.datasource.url"));
        SpringApplication.run(TodoApplication.class, args);
    }


    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


}

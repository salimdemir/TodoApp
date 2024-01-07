package com.todo.todo.core.utilities;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(String message){
        super(message);
    }

}

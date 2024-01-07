package com.todo.todo.business.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateTodoRequest {

    String name;
    boolean checked;
}

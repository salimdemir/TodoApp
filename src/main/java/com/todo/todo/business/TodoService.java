package com.todo.todo.business;

import com.todo.todo.business.request.TodoRequest;
import com.todo.todo.business.request.UpdateTodoRequest;
import com.todo.todo.business.response.GetByIdResponse;
import com.todo.todo.business.response.TodoResponse;

import java.util.List;

public interface TodoService {

    List<TodoResponse>listAll();
    void save(TodoRequest todoRequest);

    void delete(int id);

   GetByIdResponse getById(int id);

void update(int id, UpdateTodoRequest updateTodoRequest);


}

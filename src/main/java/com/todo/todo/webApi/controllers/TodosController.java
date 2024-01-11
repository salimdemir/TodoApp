package com.todo.todo.webApi.controllers;


import com.todo.todo.business.TodoService;
import com.todo.todo.business.request.TodoRequest;
import com.todo.todo.business.request.UpdateTodoRequest;
import com.todo.todo.business.response.GetByIdResponse;
import com.todo.todo.business.response.TodoResponse;
//import com.todo.todo.configuration.MyServerConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/todos")
public class TodosController {


    private TodoService todoService;


    @GetMapping()
    public List<TodoResponse> listAll() {
        return todoService.listAll();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody TodoRequest todoRequest) {
        this.todoService.save(todoRequest);
    }


    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.todoService.delete(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/{id}")
    public GetByIdResponse getById(@PathVariable int id) {
        return todoService.getById(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("update/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateTodoRequest updateTodoRequest) {
        todoService.update(id, updateTodoRequest);
    }


}

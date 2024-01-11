package com.todo.todo.business;

import com.todo.todo.business.request.TodoRequest;
import com.todo.todo.business.request.UpdateTodoRequest;
import com.todo.todo.business.response.GetByIdResponse;
import com.todo.todo.business.response.TodoResponse;
import com.todo.todo.business.rules.TodoRules;
import com.todo.todo.dataAccess.TodoRepository;
import com.todo.todo.entities.Todo;
import com.todo.todo.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TodoManager implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapperService modelMapperService;
    private TodoRules todoRules;


    public List<TodoResponse> listAllActive() {

        List<Todo> all = todoRepository.findAll();
        List<TodoResponse> list = all.stream()
                .filter(todo -> !todo.isChecked())
                .map(todo -> new TodoResponse(todo.getId(), todo.getName(), todo.isChecked()))
                .collect(Collectors.toList());
        return list;

    }

    @Override
    public List<TodoResponse> listAll() {

        todoRules.checkIfEmptyList();

        List<Todo> todoList = todoRepository.findAll();
        List<TodoResponse> todoResponseList = todoList.stream()
                .map(todo -> this.modelMapperService.forResponse()
                        .map(todo, TodoResponse.class)).collect(Collectors.toList());
        return todoResponseList;

    }

    @Override
    public void save(TodoRequest todoRequest) {
        this.todoRules.checkIfTodoExists(todoRequest.getName());
        Todo todo = this.modelMapperService.forRequest().map(todoRequest, Todo.class);
        this.todoRepository.save(todo);
    }


    @Override
    public void delete(int id) {
        this.todoRepository.deleteById(id);
    }

    @Override
    public GetByIdResponse getById(int id) {
        this.todoRules.checkIfInvalidId(id);

        Todo todo = this.todoRepository.findById(id).orElseThrow();
        GetByIdResponse getByIdResponse = this.modelMapperService.forResponse().map(todo, GetByIdResponse.class);
        return getByIdResponse;
    }

    @Override
    public void update(int id, UpdateTodoRequest updateTodoRequest) {
        Todo todo = this.todoRepository.findById(id).orElseThrow();
        todo.setName(updateTodoRequest.getName());
        todo.setChecked(updateTodoRequest.isChecked());
        todoRepository.save(todo);

    }


}

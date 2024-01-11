package com.todo.todo.business;

import com.todo.todo.business.request.UpdateTodoRequest;
import com.todo.todo.business.response.TodoResponse;
import com.todo.todo.dataAccess.TodoRepository;
import com.todo.todo.entities.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TodoManagerTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoManager todoManager;


    @Test
    public void shouldReturnAllActiveTodos() {
        //given
        Mockito.when(todoRepository.findAll()).thenReturn(getTestData());

        //when
        List<TodoResponse> todos = todoManager.listAllActive();

        //then
        assertEquals(2, todos.size());
        for (TodoResponse todo : todos) {
            assertFalse(todo.isChecked());
        }
    }

    @Test
    public void shouldDeleteTodoByGivenIdParameter() {

        todoManager.delete(123);

        Mockito.verify(todoRepository, Mockito.times(1)).deleteById(123);

    }

    @Test
    public void shouldUpdateTodo() {
        //given
        Mockito.when(todoRepository.findById(123)).thenReturn(Optional.of(new Todo(123, "Todo", false)));
        //when
        todoManager.update(123, new UpdateTodoRequest("updated todo", true));

        //then
        Mockito.verify(todoRepository).save(new Todo(123, "updated todo", true));
    }

    private static List<Todo> getTestData() {
        return Arrays.asList(
                new Todo(1, "title 1", false),
                new Todo(2, "title 2", true),
                new Todo(3, "title 3", false));
    }


}
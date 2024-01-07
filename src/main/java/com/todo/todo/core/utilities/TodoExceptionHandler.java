package com.todo.todo.core.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class TodoExceptionHandler {

    @ExceptionHandler(TodoCannotExists_Exception.class)
    public ResponseEntity<?> existsTodo(TodoCannotExists_Exception todoCannotExistsException){

        List<String>detail=new ArrayList<>();
        detail.add(todoCannotExistsException.getMessage());

        ErrorResponse errorResponse = new ErrorResponse("Todo name is already exists",detail);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);  // not found
    }



    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<?> notFoundTodo(TodoNotFoundException todoNotFoundException){

        List<String>detail=new ArrayList<>();
        detail.add(todoNotFoundException.getMessage());

        ErrorResponse errorResponse = new ErrorResponse("Todo not found",detail);

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);  // not found
    }


    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<?> emptyTodoList(EmptyListException emptyListException){
        List<String> detail = new ArrayList<>();
        detail.add(emptyListException.getMessage());

        ErrorResponse errorResponse = new ErrorResponse("Liste bos",detail);

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}

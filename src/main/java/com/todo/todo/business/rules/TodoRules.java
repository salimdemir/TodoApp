package com.todo.todo.business.rules;

import com.todo.todo.core.utilities.EmptyListException;
import com.todo.todo.core.utilities.TodoCannotExists_Exception;
import com.todo.todo.core.utilities.TodoNotFoundException;
import com.todo.todo.dataAccess.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TodoRules {

    TodoRepository todoRepository;
    public void checkIfTodoExists(String name) throws TodoCannotExists_Exception{

        if (todoRepository.existsByName(name)){
            throw new TodoCannotExists_Exception("var olan todo eklemeye çaışıyorsunuz");
        }
    }



    public void checkIfInvalidId(int id)throws TodoNotFoundException{
       if (todoRepository.existsById(id)){

        }
       else {
           throw new TodoNotFoundException("mevcut olmayan bir id numarasi giriyorsunuz");
       }

    }





    public void checkIfEmptyList()throws EmptyListException{
        if (todoRepository.findAll().isEmpty()){
            throw new EmptyListException("yapilacak todo bulunmamaktadir");
        }
    }
}

package com.todo.todo.dataAccess;

import com.todo.todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer> {

    boolean existsByName(String name);
}

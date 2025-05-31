package org.example.todoapispringg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private static List<ToDo> todoList;
    public TodoController() {
        todoList = new ArrayList<>();
        todoList.add(new ToDo(1,false,"Todo 1",1));
        todoList.add(new ToDo(2,true,"Todo 2",2));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> getTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(todoList);
    }

    @PostMapping("/todos")
    public ResponseEntity<ToDo> createTodo(@RequestBody ToDo newToDo) {

        /*
        // we can use this annotation to set the status code @ResponseStatus(HttpStatus.CREATED)
        */
        todoList.add(newToDo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newToDo);
    }
}

package org.example.todoapispringg;

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
    public List<ToDo> getTodos() {
        return todoList;
    }

    @PostMapping("/todos")
    public ToDo createTodo(@RequestBody ToDo newToDo) {
        todoList.add(newToDo);
        return newToDo;
    }
}

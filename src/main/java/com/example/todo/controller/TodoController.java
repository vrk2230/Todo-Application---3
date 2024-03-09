package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoJpaService;

import java.util.*;

@RestController
public class TodoController {

    @Autowired
    private TodoJpaService todoJpaService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoJpaService.getTodo();
    }

    @GetMapping("/todos/{todosId}")
    public Todo getTodoById(@PathVariable("todosId") int id) {
        return todoJpaService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoJpaService.addTodo(todo);
    }

    @PutMapping("/todos/{todosId}")
    public Todo updateTodo(@PathVariable("todosId") int id, @RequestBody Todo todo) {
        return todoJpaService.updaTodo(id, todo);
    }

    @DeleteMapping("/todos/{todosId}")
    void deleteTodo(@PathVariable("todosId") int id) {
        todoJpaService.deleteTodo(id);
    }
}
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

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoJpaService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoJpaService.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return todoJpaService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    void deleteTodo(@PathVariable("id") int id) {
        todoJpaService.deleteTodo(id);
    }
}
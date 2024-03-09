package com.example.todo.repository;

import java.util.ArrayList;

import com.example.todo.model.Todo;

/**
 * TodoRepository
 */
public interface TodoRepository {
    ArrayList<Todo> getTodo();

    Todo getTodoById(int id);

    Todo addTodo(Todo todo);

    Todo updaTodo(int id, Todo todo);

    void deleteTodo(int id);
}
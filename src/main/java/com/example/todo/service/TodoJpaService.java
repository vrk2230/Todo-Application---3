package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.repository.TodoRepository;

import java.util.*;

/**
 * TodoJpaService
 */
@Service
public class TodoJpaService implements TodoRepository {

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @Override
    public ArrayList<Todo> getTodo() {
        List<Todo> todoList = todoJpaRepository.findAll();
        ArrayList<Todo> todo = new ArrayList<>(todoList);
        return todo;
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            return todoJpaRepository.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo addTodo(Todo todo) {
        return todoJpaRepository.save(todo);
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        try {
            Todo updatedTodo = todoJpaRepository.findById(id).get();
            if (updatedTodo.getTodo() != null) {
                updatedTodo.setTodo(todo.getTodo());
            }
            if (updatedTodo.getStatus() != null) {
                updatedTodo.setStatus(todo.getStatus());
            }
            if (updatedTodo.getPriority() != null) {
                updatedTodo.setPriority(todo.getPriority());
            }

            todoJpaRepository.save(updatedTodo);
            return updatedTodo;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {
        try {
            todoJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
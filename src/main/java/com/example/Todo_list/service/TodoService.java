package com.example.Todo_list.service;

import com.example.Todo_list.model.Todo;
import com.example.Todo_list.repo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> getAll() {
        return repo.findAll();
    }

    public Todo create(Todo todo) {
        return repo.save(todo);
    }

    public Todo getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Todo update(Long id, Todo newTodo) {
        Todo old = getById(id);
        old.setTitleName(newTodo.getTitleName());
        old.setDescription(newTodo.getDescription());
        old.setCompleted(newTodo.isCompleted());
        return repo.save(old);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

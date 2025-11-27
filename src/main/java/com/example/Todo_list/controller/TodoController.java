package com.example.Todo_list.controller;


import com.example.Todo_list.model.Todo;
import com.example.Todo_list.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("*")   // to allow frontend later
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        return new ResponseEntity<>(service.create(todo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Todo get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        return service.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

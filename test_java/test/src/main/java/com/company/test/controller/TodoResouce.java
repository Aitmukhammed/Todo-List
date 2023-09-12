package com.company.test.controller;

import com.company.test.model.Todo;
import com.company.test.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoList")
public class TodoResouce {
    private final TodoService todoService;

    public TodoResouce(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllLists() {
        List<Todo> todo_lists = todoService.findAllLists();
        return new ResponseEntity<>(todo_lists, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Todo> getListById(@PathVariable("id") Long id) {
        Todo todo = todoService.findListById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Todo> addList(@RequestBody Todo todo) {
        Todo newTodo = todoService.addList(todo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Todo> updateList(@RequestBody Todo todo) {
        Todo updateTodo = todoService.updateList(todo);
        return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteList(@PathVariable("id") Long id) {
        todoService.deleteList(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

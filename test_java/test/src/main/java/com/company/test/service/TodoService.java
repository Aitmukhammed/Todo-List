package com.company.test.service;

import com.company.test.exception.ListNotFoundException;
import com.company.test.model.Todo;
import com.company.test.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@Service
public class TodoService {
    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo addList(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findAllLists() {
        return todoRepository.findAll();
    }

    public Todo updateList(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findListById(Long id) {
        return todoRepository.findListById(id)
                .orElseThrow(() -> new ListNotFoundException("Todo-list by id" + id + "was not found"));
    }
    public void deleteList(Long id){
        todoRepository.deleteListById(id);
    }

}

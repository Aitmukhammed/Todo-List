package com.company.test.repository;

import com.company.test.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    void deleteListById(Long id);
    Optional<Todo> findListById(Long id);
}

package com.todo.todo.repository;

import com.todo.todo.entity.Task;
import com.todo.todo.types.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByCreatedAt(LocalDateTime created_at);

    List<Task> findByStatus(Status s);


}

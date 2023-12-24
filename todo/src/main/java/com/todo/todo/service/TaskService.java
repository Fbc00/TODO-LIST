package com.todo.todo.service;

import com.todo.todo.entity.Task;
import com.todo.todo.entity.form.CreateTaskForm;
import com.todo.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;



}

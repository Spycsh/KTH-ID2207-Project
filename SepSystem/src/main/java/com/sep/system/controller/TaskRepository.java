package com.sep.system.controller;
import com.sep.system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepository extends JpaRepository<Task, Integer>{
    
}

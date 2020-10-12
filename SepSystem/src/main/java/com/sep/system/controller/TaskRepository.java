package com.sep.system.controller;

import java.util.List;

import com.sep.system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepository extends JpaRepository<Task, Integer>{
    public List<Task> findByDepartment(String department);
    public List<Task> findById(int id);
    public List<Task> findByEmployeeId(int id);
}

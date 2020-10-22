package com.sep.system.controller;

import java.util.List;

import com.sep.system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    public List<Employee> findByName(String name);
    public List<Employee> findByDepartment(String department);
    public List<Employee> findById(int id);

}




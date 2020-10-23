package com.sep.system.models;

import com.sep.system.controller.EmployeeRepository;
import com.sep.system.model.Employee;
import com.sep.system.model.Event;
import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.is;


@SpringBootTest
public class EmployeeTest {
    Employee employee;
    @Autowired
    private EmployeeRepository employeeRepository;

    //test to create an employee
    @Test
    public void createEmployeeTest(){
        employee = new Employee("testEmployee", "admin manager", "mike", "admin");
        employeeRepository.save(employee);
        Employee e = employeeRepository.findByName("testEmployee").get(0);
        Assert.assertEquals(e.getRole(), "admin manager");
        Assert.assertEquals(e.getDepartment(), "admin");
        Assert.assertEquals(e.getPassword(), "mike");
        employeeRepository.deleteById(e.getId());

    }


    //this method is not used in the system
    //just for clearing the data which was created in the test
    // @Test
    // public void deleteEmployeeTest(){
    //     List<Employee> employees = employeeRepository.findByName("testEmployee");
    //     if(employees.size()>0) {
    //         Employee e = employees.get(0);
    //         employeeRepository.deleteById(e.getId());
    //     }
    //     Assert.assertEquals(0, employeeRepository.findByName("testEmployee").size());
    // }
}




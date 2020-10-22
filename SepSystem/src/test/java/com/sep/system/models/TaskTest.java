package com.sep.system.models;

import com.sep.system.controller.FinancialRequestRepository;
import com.sep.system.controller.TaskRepository;
import com.sep.system.model.FinancialRequest;
import com.sep.system.model.Task;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class TaskTest {
    Task task;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void createTaskTest(){
//        int eventId, int employeeId, String subject,
//                String description, int sender, String department, String priority, String status,String employeeName
        task = new Task(2, 333, "take photos", "in front of the palace",
                777, "testapartment", "high", "Draft","testEmployee");
        taskRepository.save(task);
        Task e = taskRepository.findByEmployeeId(333).get(0);
        Assert.assertEquals(e.getEventId(), 2);
        Assert.assertEquals(e.getSubject(), "take photos");
        Assert.assertEquals(e.getSenderId(), 777);
        Assert.assertEquals(e.getDescription(), "in front of the palace");
        Assert.assertEquals(e.getDepartment(), "testapartment");
        Assert.assertEquals(e.getPriority(), "high");
        Assert.assertEquals(e.getStatus(), "Draft");
        Assert.assertEquals(e.getEmployeeName(), "testEmployee");
    }

    @Test
    public void editTaskTest(){
        Task e = taskRepository.findByEmployeeId(333).get(0);
        e.setStatus("Edited");
        Assert.assertEquals("Edited", e.getStatus());
    }

    @Test
    public void deleteTaskTest(){
        List<Task> ta = taskRepository.findByEmployeeId(777);
        if(ta.size()>0) {
            Task t = ta.get(0);
            taskRepository.deleteById(t.getId());
        }
        Assert.assertEquals(0, taskRepository.findByEmployeeId(777).size());
    }
}
package com.sep.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sep.system.model.Employee;
import com.sep.system.model.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/taskManagement")
    public String eventManagement(HttpServletRequest request,Map<String, Object> map) {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        int userId = (int) session.getAttribute("userId");
        String department = (String) session.getAttribute("department");
        
        if(role.equals("production manager")|role.equals("service manager")){
            // production manager and service manager can create tasks
            session.setAttribute("createTaskEnable", "createButton");
            List<Task> taskList = taskRepository.findByDepartment(department);
            map.put("tasklist", taskList);
        }else{
            //service and production team member can not create tasks
            session.setAttribute("createTaskEnable", "hidden");
            //view and edit their own tasks
            List<Task> taskList = taskRepository.findByEmployeeId(userId);
            map.put("tasklist", taskList);
        }
       
       

       
        return "taskManagement";
    }

    @RequestMapping("/createTask")
    public String createTaskPage(HttpServletRequest request,Map<String, Object> map){
        HttpSession session = request.getSession();
        String dep = (String) session.getAttribute("department");
        List<Employee> employeeList = employeeRepository.findByDepartment(dep);

        map.put("employeelist",employeeList);

        return "createTaskRequest";        // go to createTaskRequest.html
    }


    @PostMapping(value = "/createTaskRequest")
    public String createEvent(@RequestParam("eventId") int eventId, @RequestParam("employeeId") int employeeId,
                              @RequestParam("subject") String subject, @RequestParam("description") String description,
                              @RequestParam("priority") String priority,
                              Map<String, Object> map,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String employeeName = employeeRepository.findById(employeeId).get(0).getName();

        Task task = new Task(eventId,employeeId,subject,description,(int) session.getAttribute("userId"),
        (String)session.getAttribute("department"),priority,"Draft",employeeName);

        taskRepository.save(task);

        return "redirect:/taskManagement";     // must use redirect here

    }

     //for insert a few data into the database
     @RequestMapping(value = "/insertTestTask")
     public String insertTestTask(){
         List<Task> taskList = new ArrayList<Task>();
         taskList.add(new Task(0, 7, "flower photo", "take a picture of flower", 6, "production", "high", "draft","tobias"));
         taskList.add(new Task(0, 9, "cook dinner", "cook beef with wine", 9, "service", "medium", "draft","helene"));
         for(Task t : taskList){
             taskRepository.save(t);
 
         }
         
         return "redirect:success";
 
     }
}

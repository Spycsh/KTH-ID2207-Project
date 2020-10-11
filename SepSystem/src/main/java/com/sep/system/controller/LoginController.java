package com.sep.system.controller;

import com.sep.system.model.Employee;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@Controller return a html page
//@RestController return a string
@Controller
public class LoginController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpSession session, Model model){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password"); // password hash
 

        List<Employee> em = employeeRepository.findByName(userName);


            if(em.get(0).getPassword().equals(password) ){

                System.out.println(password);
                System.out.println(em.get(0).getPassword());

                // setsession
                session.setAttribute("userName", userName);
                session.setAttribute("role", em.get(0).getRole());
                session.setAttribute("role", em.get(0).getRole());
                session.setAttribute("event", "event");
                return "redirect:mainPage";
            }else{

                return "redirect:loginFailure";

            }


        // get roles/menus form db



        // for each permission got from db
        // set attribute to exempt from hidden class
        // remove hidden


        
    }

    //for insert a few data into the database
    @RequestMapping(value = "/insertTestEmployee")
    public String insertTestEmployee(){
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("mike","admin manager","mike"));
        employeeList.add(new Employee("simon","HR manager","simon"));
        employeeList.add(new Employee("janet","senior customer service manager","janet"));
        employeeList.add(new Employee("sam","customer service officer","sam"));
        employeeList.add(new Employee("alice","financial manager","alice"));
        employeeList.add(new Employee("jack","production manager","jack"));
        employeeList.add(new Employee("tobias","photograhper","tobias"));
        employeeList.add(new Employee("natalie","service manager","natalie"));
        employeeList.add(new Employee("helene","top chef","helen"));

        for(Employee emp : employeeList){
            employeeRepository.save(emp);

        }
        
        return "redirect:success";

    }

}

//    @Value("${name}")
//    private String name;
//
//    @Value("${age}")
//    private Integer age;
//
//    @RequestMapping("/hello")
//    public String hello(){
//        return name + " " + age;
//    }


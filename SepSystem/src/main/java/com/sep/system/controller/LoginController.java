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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@Controller return a html page
//@RestController return a string
@Controller
public class LoginController {

    @Autowired
    private EmployeeRepository employeeRepository;


    
    @RequestMapping("/mainPage")
    public String mainPage(){

       
        return "MainPage";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpSession session, Model model){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password"); // password hash
 

        List<Employee> em = employeeRepository.findByName(userName);


            if(em.get(0).getPassword().equals(password) ){

                // System.out.println(password);
                // System.out.println(em.get(0).getPassword());

                // setsession
                session.setAttribute("userName", userName);
                session.setAttribute("role", em.get(0).getRole());
                session.setAttribute("userId",em.get(0).getId());
                session.setAttribute("department",em.get(0).getDepartment());

                // event management is only visible to customer service officer/ senior customer service manager/
                // financial manager/ admin manager
                if(em.get(0).getRole().equals("financial manager") | em.get(0).getRole().equals("admin manager")
                        | em.get(0).getRole().equals("senior customer service manager")
                        | em.get(0).getRole().equals("customer service officer")){
                    session.setAttribute("event", "event");

                }else{
                    session.setAttribute("event","hidden");
                }

                // task management is only visible to production and service department managers and staff
                if(em.get(0).getDepartment().equals("production") | em.get(0).getDepartment().equals("service")){

                    session.setAttribute("task", "task");

                }else{
                    session.setAttribute("task","hidden");
                }

                // staff management is only visible to HR manager/ production manager/ service manager
                if(em.get(0).getRole().equals("HR manager") |em.get(0).getRole().equals("production manager")
                        | em.get(0).getRole().equals("service manager")){

                    session.setAttribute("staff", "staff");

                }else{
                    session.setAttribute("staff","hidden");
                }

                // Financial management is only visible to Financial manager/ production manager/ financial manager
                if(em.get(0).getRole().equals("financial manager") | em.get(0).getRole().equals("production manager")
                        | em.get(0).getRole().equals("service manager")){
                    session.setAttribute("finance", "finance");

                }else{
                    session.setAttribute("finance","hidden");
                }

                return "redirect:mainPage";
            }else{

                return "redirect:loginFailure";

            }

    }


    @RequestMapping("/")
    public String html(){return "index";}

    @RequestMapping("/loginFailure")
    public String success(Map<String, Object> map){
        map.put("hello", "The login fails: please check the password");

        return "loginFailure";
    }


    //for insert a few data into the database
    @RequestMapping(value = "/insertTestEmployee")
    public String insertTestEmployee(){
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("mike","admin manager","mike","admin"));
        employeeList.add(new Employee("simon","HR manager","simon","admin"));
        employeeList.add(new Employee("janet","senior customer service manager","janet","admin"));
        employeeList.add(new Employee("sam","customer service officer","sam","admin"));
        employeeList.add(new Employee("alice","financial manager","alice","financial"));
        employeeList.add(new Employee("jack","production manager","jack","production"));
        employeeList.add(new Employee("tobias","photograhper","tobias","production"));
        employeeList.add(new Employee("natalie","service manager","natalie","service"));
        employeeList.add(new Employee("helene","top chef","helene","serviceS"));

        for(Employee emp : employeeList){
            employeeRepository.save(emp);

        }
        
        return "redirect:success";

    }

    @RequestMapping("/success")
    public String success(){
        return "success";
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


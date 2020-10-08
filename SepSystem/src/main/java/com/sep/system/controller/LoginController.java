package com.sep.system.controller;


import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@Controller return a html page
//@RestController return a string
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpSession session, Model model){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password"); // password hash
        // if not in db, redirect to login
        // setsession
        session.setAttribute("userName", userName);
        // get roles/menus form db

        // for each permission got from db
        // set attribute to exempt from hidden class
        // remove hidden
        session.setAttribute("event", "event");

        return "redirect:mainpage";
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


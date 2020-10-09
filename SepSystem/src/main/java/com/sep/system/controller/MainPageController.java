package com.sep.system.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainPageController {

    @RequestMapping("/mainPage")
    public String mainPage(){
       
        return "MainPage";
    }

    
}
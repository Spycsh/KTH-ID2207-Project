package com.sep.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainPageController {

    @RequestMapping("/mainpage")
    public String mainPage(){
        return "MainPage";
    }
}
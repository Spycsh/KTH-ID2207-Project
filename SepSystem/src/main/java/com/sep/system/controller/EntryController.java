package com.sep.system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class EntryController {
    @RequestMapping("/")
    public String html(){return "index";}

    @RequestMapping("/loginFailure")
    public String success(Map<String, Object> map){
        map.put("hello", "The login fails: please check the password");

        return "loginFailure";
    }
}

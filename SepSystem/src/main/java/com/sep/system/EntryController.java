package com.sep.system;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class EntryController {
    @RequestMapping("/")
    public String html(){return "index";}

    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello", "你好");

        return "success";
    }
}

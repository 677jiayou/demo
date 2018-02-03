package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class adminIndexController {

    @RequestMapping("/index1.do")
    public String toLogin(){
        return "index1";
    }
    @RequestMapping("/welcome.do")
    public String welcome(){
        return "welcome";
        
    }
}

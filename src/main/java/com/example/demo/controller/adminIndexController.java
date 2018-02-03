package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class adminIndexController {

    @RequestMapping("/index1.do")
    public String toLogin1(){
        return "index1";
    }
    @RequestMapping("/index2.do")
    public String toLogin2(){
        return "index2";
    }
    @RequestMapping("/index3.do")
    public String toLogin3(){
        return "index3";
    }
    @RequestMapping("/index4.do")
    public String toLogin4(){
        return "index4";
    }
    @RequestMapping("/welcome.do")
    public String welcome(){
        return "welcome";
    }
}

package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Position;
import com.example.demo.service.EmployeeServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class adminLoginController {

    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private HttpSession httpSession;

//    登录页面映射处理
    @GetMapping("/")
    public String toLogin(){
        return "login";
    }
//    登录时检查用户名密码是否正确的映射处理
    @PostMapping("/actionLogin.do")
    @ResponseBody
    public String actionLogin(@RequestParam("loginUserName") Integer username,@RequestParam("loginPassword") String password){
        Employee employee=employeeService.findEmployeeByNumAndPassword(username,password);
        httpSession.removeAttribute("employee");
        httpSession.setAttribute("employee",employee);
        return  new Gson().toJson(employee);
    }

    @GetMapping("/goWelcome.do")
    public String goIndex(){
        return "welcome";
    }

    //注销登录
    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        session.removeAttribute("employee");
        return "login";
    }
    //退出登录
    @RequestMapping("/login.do")
    public String Login(){
        return "login";
    }
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
public class adminLeaveController {
    // 个人请假申请页面映射处理
    @RequestMapping("/leaveAdd.do")
    public String toLeave(){

        System.out.println("进来了");
        return "leave_add";
    }
}

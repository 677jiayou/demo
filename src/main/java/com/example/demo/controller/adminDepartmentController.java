package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin
public class adminDepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private HttpSession session;
    @RequestMapping("/departmentList.do")
    public String departmentList(){
        List<Department> departmentList=departmentService.getAllDepartmentInfo();
        session.setAttribute("departmentList",departmentList);
        return "department_list";
    }
}

package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin
public class adminDepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private HttpSession session;

    //部门信息展示映射
    @RequestMapping("/departmentList.do")
    public String departmentList(){
        List<Department> departmentList=departmentService.getAllDepartmentInfo();
        session.setAttribute("departmentList",departmentList);
        return "department_list";
    }
    //去到部门信息修改页面的映射
    @RequestMapping("/toDepartmentUpdate.do")
    public String toDepartmentUpdate(@RequestParam("departmentNumber")Integer departmentNumber){

        Department department=departmentService.getDepartmentByDepartmentNumber(departmentNumber);
        session.setAttribute("department",department);

        return "department_update";
    }

    //部门信息修改页面表单提交处理的映射
    @PostMapping ("/departmentUpdate.do")
    public ModelAndView historyUpdate(@ModelAttribute(value = "Department") Department department){

        departmentService.updateDepartment(department);

        return new ModelAndView("redirect:/departmentList.do");

    }

    //去到新增部门页面的映射
    @RequestMapping("/toAddDepartment.do")
    public String toAddDepartment(){

        Integer maxDepartmentNumber=departmentService.getMaxdepartmentNumber()+1;
        session.setAttribute("maxDepartmentNumber",maxDepartmentNumber);
        return "department_add";
    }
    //新增页面表单提交处理映射
    @PostMapping("/addDepartment.do")
    public ModelAndView addDepartment(@ModelAttribute(value = "Department")Department department){
        departmentService.saveNewDepartment(department);
        return new ModelAndView("redirect:/departmentList.do");
    }

    //删除部门信息
    @GetMapping("/deleteDepartment.do")
    public ModelAndView deleteDepartment(@RequestParam("departmentNumber")Integer departmentNumber){

        departmentService.deleteDepartment(departmentNumber);
        return new ModelAndView("redirect:/departmentList.do");
    }
}

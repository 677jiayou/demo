package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repostry.AttendanceMapper;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jnlp.PersistenceService;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin
public class adminEmployeeInfoController {

    @Autowired
    private HttpSession session;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private OvertimeServiceImpl overtimeService;
    @Autowired
    private AttendanceServiceImpl attendanceService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    // 个人信息页面映射处理
    @GetMapping("/employeeDetail.do")
    public String toDetail(){
        return "employee_detail";
    }

    // 个人信息修改页面映射处理
    @GetMapping("/employee_update.do")
    public String toUpdate(){
        List<Position> positionList=positionService.getAllPositionInfo();
        List<Department> departmentList=departmentService.getAllDepartmentInfo();
        session.setAttribute("positionList",positionList);
        session.setAttribute("departmentList",departmentList);
        return "employee_update";
    }

    //个人请假信息
    @GetMapping("/attendance.do")
    public String attendance(@RequestParam("employeeNumber") Integer employeeNumber){
        List<Attendance> attendanceList=attendanceService.getAttendanceByEmployeeNum(employeeNumber);
        session.setAttribute("attendanceList",attendanceList);
        return "attendance";
    }

    //个人加班信息
    @GetMapping("/overtime.do")
    public String overtime(@RequestParam("employeeNumber") Integer employeeNumber){
        List<Overtime> overtimeList=overtimeService.getOvertiomByEmployeeNumber(employeeNumber);

        session.setAttribute("overtimeList",overtimeList);
        return "overtime";
    }
    //在职员工管理
    @RequestMapping("/employeelist")
    public String employeelist(){
        List<Employee> employeeList=employeeService.findAllEmployee();
        for (Employee employee:employeeList
             ) {
            employee.setDepartment(departmentService.getDepartmentByDepartmentNumber(employee.getDepartmentNumber()));
            employee.setPosition(positionService.getPositionByPositionNumber(employee.getPositionNumber()));
        }
        session.setAttribute("employeeList",employeeList);
        return  "employee_list";
    }

}

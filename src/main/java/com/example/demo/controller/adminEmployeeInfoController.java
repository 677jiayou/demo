package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repostry.AttendanceMapper;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        Employee employee= (Employee) session.getAttribute("employee");
        session.removeAttribute("employee");
        Employee employee1=employeeService.findEmployeeByEmployeeNumber(employee.getEmployeeNumber());
        session.setAttribute("employee",employee1);
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

    //修改个人信息处理
    @PostMapping("/employeeUpdate.do")
    public ModelAndView employeeUpdate(@ModelAttribute(value="Employee") Employee employee){
        boolean flag=employeeService.updateEmployee(employee);
        System.out.println("更新结果："+flag);
        return new ModelAndView("redirect:/employeeDetail.do");
    }

    //个人请假信息
    @GetMapping("/attendance.do")
    public String attendance(@RequestParam("employeeNumber") Integer employeeNumber){
        List<Attendance> attendanceList=attendanceService.getAttendanceByEmployeeNum(employeeNumber);
        session.setAttribute("attendanceList",attendanceList);
        return "attendance";
    }
    //全部请假信息映射
    @GetMapping("/attendanceList.do")
    public String attendanceList(){
        List<Attendance> attendanceList=attendanceService.getAllAttendance();
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
    //所有员工加班信息
    @GetMapping("/Allovertime.do")
    public String overtime(){
        List<Overtime> allOvertimeList=overtimeService.getAllOverTime();

        session.setAttribute("allOvertimeList",allOvertimeList);
        return "overtime_list";
    }

    //去安排加班
    @GetMapping("/overtimeToAdd.do")
    public String overtimeToAdd(){
        List<Employee> employeeList=employeeService.findAllEmployee();
        List<Department> departmentList=departmentService.getAllDepartmentInfo();
        session.setAttribute("employeeList",employeeList);
        session.setAttribute("departmentList",departmentList);
        return "overtime_add";
    }
    //新增加班信息
    @PostMapping("/overtimeAdd.do")
    public ModelAndView overtimeAdd(@ModelAttribute(value="Overtime") Overtime overtime){

        boolean flag=overtimeService.saveOvertime(overtime);
        System.out.println(false);
        System.out.println(overtime);

        return new ModelAndView("redirect:/Allovertime.do");

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

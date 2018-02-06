package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repostry.AttendanceMapper;
import com.example.demo.repostry.HistoryMapper;
import com.example.demo.service.*;
import com.example.demo.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jnlp.PersistenceService;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private HistoryServiceImpl historyService;

    @RequestMapping("/addStartTime.do")
    public String addStartTime(@RequestParam("employeeNumber") Integer employeeNumber){
        attendanceService.addStart(employeeNumber);
        return "welcome";
    }

    @RequestMapping("/addEndTime.do")
    public String addEndTime(@RequestParam("employeeNumber") Integer employeeNumber){
        attendanceService.addEnd(employeeNumber);
        return "welcome";
    }




    // 个人信息页面映射处理
    @GetMapping("/employeeDetail.do")
    public String toDetail(@RequestParam("employeeNumber") Integer employeeNumber) {
        Employee employee1 = employeeService.findEmployeeByEmployeeNumber(employeeNumber);
        session.setAttribute("employee", employee1);
        return "employee_detail";
    }

    // 个人信息修改页面映射处理
    @GetMapping("/employee_update.do")
    public String toUpdate(@RequestParam("employeeNumber") Integer employeeNumber) {
        List<Position> positionList = positionService.getAllPositionInfo();
        List<Department> departmentList = departmentService.getAllDepartmentInfo();
        Employee employee1 = employeeService.findEmployeeByEmployeeNumber(employeeNumber);
        session.setAttribute("employee", employee1);
        session.setAttribute("positionList", positionList);
        session.setAttribute("departmentList", departmentList);
        return "employee_update";
    }

    //修改个人信息处理
    @PostMapping("/employeeUpdate.do")
    public ModelAndView employeeUpdate(@ModelAttribute(value = "Employee") Employee employee, @ModelAttribute(value = "date") String date) {
        employee.setBirthday(MTimeUtil.stringParse(date));
        boolean flag = employeeService.updateEmployee(employee);
        Employee employee1 = employeeService.findEmployeeByEmployeeNumber(employee.getEmployeeNumber());
        session.setAttribute("employee", employee1);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("employee_detail");
        return modelAndView;
    }



    //个人考勤信息
    @GetMapping("/attendance.do")
    public String attendance(@RequestParam("employeeNumber") Integer employeeNumber) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByEmployeeNum(employeeNumber);
        session.setAttribute("attendances", attendanceList);
        return "attendance";
    }

    //全部人员考勤信息映射
    @GetMapping("/attendanceList.do")
    public String attendanceList() {
        List<Attendance> attendanceList = attendanceService.getAllAttendance();
        session.setAttribute("attendanceList", attendanceList);
        return "attendance_list";
    }


    //个人加班信息
    @GetMapping("/overtime.do")
    public String overtime(@RequestParam("employeeNumber") Integer employeeNumber) {
        List<Overtime> overtimeList = overtimeService.getOvertiomByEmployeeNumber(employeeNumber);
        session.setAttribute("overtimeList", overtimeList);
        return "overtime";
    }

    //所有员工加班信息
    @GetMapping("/Allovertime.do")
    public String overtime() {
        List<Overtime> allOvertimeList = overtimeService.getAllOverTime();

        session.setAttribute("allOvertimeList", allOvertimeList);
        return "overtime_list";
    }

    //去安排加班
    @GetMapping("/overtimeToAdd.do")
    public String overtimeToAdd() {
        List<Employee> employeeList = employeeService.findAllEmployee();
        List<Department> departmentList = departmentService.getAllDepartmentInfo();
        session.setAttribute("employeeList", employeeList);
        session.setAttribute("departmentList", departmentList);
        return "overtime_add";
    }

    //新增加班信息
    @PostMapping("/overtimeAdd.do")
    public ModelAndView overtimeAdd(@ModelAttribute(value = "Overtime") Overtime overtime, @ModelAttribute(value = "date") String date) {
        overtime.setDay(MTimeUtil.stringParse(date));
        boolean flag = overtimeService.saveOvertime(overtime);
        System.out.println(false);
        System.out.println(overtime);

        return new ModelAndView("redirect:/Allovertime.do");

    }
    //去修改加班信息页面的映射
    @GetMapping("/toUpdateOvertime.do")
    public String toUpdateOvertime(@RequestParam("id") Integer id){
        Overtime overtime=overtimeService.getOvertimeById(id);
        List<Employee> employeeList = employeeService.findAllEmployee();
        List<Department> departmentList = departmentService.getAllDepartmentInfo();
        session.setAttribute("employeeList", employeeList);
        session.setAttribute("departmentList", departmentList);
        session.setAttribute("overtime",overtime);
        return "overtime_update";
    }
    //修改加班信息表单提交映射
    @PostMapping("/updateOvertime.do")
    public ModelAndView updateOvertime(@ModelAttribute(value = "Overtime") Overtime overtime,@ModelAttribute(value = "date") String date,@ModelAttribute(value = "id") Integer id){
        overtime.setDay(MTimeUtil.stringParse(date));
        overtimeService.updateOvertime(overtime,id);
        return new ModelAndView("redirect:/Allovertime.do");
    }
    //在职员工管理
    @RequestMapping("/employeelist")
    public String employeelist() {
        List<Employee> employeeList = employeeService.findAllEmployee();
        for (Employee employee : employeeList
                ) {
            employee.setDepartment(departmentService.getDepartmentByDepartmentNumber(employee.getDepartmentNumber()));
            employee.setPosition(positionService.getPositionByPositionNumber(employee.getPositionNumber()));
        }
        session.setAttribute("employeeList", employeeList);
        return "employee_list";
    }

    //新增员工
    @RequestMapping("/toAddEmployee.do")
    public String employeeAdd() {
        List<Department> departmentList = departmentService.getAllDepartmentInfo();
        List<Position> positionList = positionService.getAllPositionInfo();
        Common common=new Common();
        Integer maxNum = employeeService.maxEmployeeNumber()+1;
        common.setNewEmployeeNumber(maxNum);
        session.setAttribute("departmentList", departmentList);
        session.setAttribute("positionList", positionList);
        session.setAttribute("maxNum", maxNum);
        System.out.println(common);
        return "employee_add";
    }

    //处理新增员工表单
    //新增加班信息
    @PostMapping("/employeeAdd.do")
    public ModelAndView employeeAdd(@ModelAttribute(value = "Employee") Employee employee, @ModelAttribute(value = "date") String date) {
        Date date1=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String inTime=sdf.format(date1);
        employee.setBirthday(MTimeUtil.stringParse(date));
        employee.setInTime(MTimeUtil.stringParse(inTime));
        employeeService.saveNewEmployee(employee);


        History history=new History();
        history.setAddress(employee.getAddress());
        history.setBirthday(employee.getBirthday());
        history.setDepartmentNumber(employee.getDepartmentNumber());
        history.setEducation(employee.getEducation());
        history.setEmail(employee.getEmail());
        history.setEmployeeNumber(employee.getEmployeeNumber());
        history.setGender(employee.getGender());
        history.setPositionNumber(employee.getPositionNumber());
        history.setInTime(employee.getInTime());
        history.setName(employee.getName());
        history.setNotes(employee.getNotes());
        history.setTelephone(employee.getTelephone());

        historyService.saveHistory(history);

        return new ModelAndView("redirect:/employeelist.do");

    }
    //删除员工信息
    @GetMapping("/employeeDelete.do")
    public ModelAndView employeeDelete(@RequestParam("employeeNumber") Integer employeeNumber) {
       employeeService.deleteEmployee(employeeNumber);
        return new ModelAndView("redirect:/employeelist.do");
    }

    //员工姓名的模糊查询
    @PostMapping("/searchEmployees.do")
    public ModelAndView searchEmployees(@RequestParam("input") String input){
        input="%"+input+"%";
        List<Employee> employeeList= employeeService.getEmployeesByInput(input);
        session.setAttribute("employeeList", employeeList);
        return new ModelAndView("employee_list");
    }

}

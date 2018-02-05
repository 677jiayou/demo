package com.example.demo.controller;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Lea;
import com.example.demo.service.LeaServiceImpl;
import com.example.demo.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@CrossOrigin
public class adminLeaveController {

    @Autowired
    private LeaServiceImpl leaService;
    @Autowired
    private HttpSession session;
    // 个人请假申请页面映射处理
    @RequestMapping("/leaveAdd.do")
    public String toLeave(){
        return "leave_add";
    }
    //请假表单提交处理映射
    @RequestMapping("/submintLeaveAdd.do")
    public ModelAndView submintLeaveAdd(@ModelAttribute(value="Lea") Lea lea,@ModelAttribute(value="start")String start,@ModelAttribute(value="end")String end ){
        lea.setStartTime(MTimeUtil.stringParse(start));
        lea.setEndTime(MTimeUtil.stringParse(end));
        Employee employee= (Employee) session.getAttribute("employee");
        lea.setEmployeeNumber(employee.getEmployeeNumber());
        lea.setDepartmentNumber(employee.getDepartmentNumber());
        lea.setStatus("未批准");
        leaService.saveLea(lea);
        return new ModelAndView("redirect:/leaveList.do");
    }
    //请假记录页面映射
    @RequestMapping("/leaveRecord.do")
    public String leaveRecord(@RequestParam("employeeNumber")Integer employeeNumber){
        List<Lea> leaList=leaService.getLeasByaEmployeeNumber(employeeNumber);
        session.setAttribute("leaList",leaList);
        return "leaves_record";
    }
    //全部请假记录
    @RequestMapping("/leaveList.do")
    public String leaveList(){
        List<Lea> allLeaList=leaService.getAllLeas();
        session.setAttribute("allLeaList",allLeaList);
        return "leaves_list";
    }
    //已批准请假记录
    @RequestMapping("/yesleaveList.do")
    public String yesleaveList(@RequestParam("status")String status){
        List<Lea> yesLeaList=leaService.getLeasByStatus(status);
        session.setAttribute("yesLeaList",yesLeaList);
        return "yes_leaves_list";
    }
    //未批准请假记录
    @RequestMapping("/noleaveList.do")
    public String noleaveList(@RequestParam("status")String status){
        List<Lea> noLeaList=leaService.getLeasByStatus(status);
        session.setAttribute("noLeaList",noLeaList);
        return "no_leaves_list";
    }
    //去请假记录详情页
    @RequestMapping("/goLeaveDetail.do")
    public String goLeaveDetail(@RequestParam("id")Integer id ){
        Lea lea=leaService.getLeaById(id);
        session.setAttribute("lea",lea);
        return "leave_detail";
    }
    //批准请假
    @RequestMapping("/leaveOk.do")
    public ModelAndView leaveOk(@RequestParam("id")Integer id ){
        leaService.leaveSuccess(id);
        return new ModelAndView("redirect:/noNoNOleaveList.do");
    }
    //未批准请假记录2（批准操作后返回专用！）
    @RequestMapping("/noNoNOleaveList.do")
    public String noleaveList(){
        List<Lea> noLeaList=leaService.getLeasByStatus("未批准");
        session.setAttribute("noLeaList",noLeaList);
        return "no_leaves_list";
    }
}

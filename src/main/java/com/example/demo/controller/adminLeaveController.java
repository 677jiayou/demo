package com.example.demo.controller;

import com.example.demo.entity.Lea;
import com.example.demo.service.LeaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    //请假记录页面映射
    @RequestMapping("/leaveRecord.do")
    public String leaveRecord(@RequestParam("employeeNumber")Integer employeeNumber){
        List<Lea> leaList=leaService.getLeasByaEmployeeNumber(employeeNumber);
        session.setAttribute("leaList",leaList);
        return "leaves_record";
    }

    @RequestMapping("/leaveList.do")
    public String leaveList(){
        List<Lea> allLeaList=leaService.getAllLeas();
        session.setAttribute("allLeaList",allLeaList);
        return "leaves_list";
    }
    @RequestMapping("/yesleaveList.do")
    public String yesleaveList(@RequestParam("status")String status){
        List<Lea> yesLeaList=leaService.getLeasByStatus(status);
        session.setAttribute("yesLeaList",yesLeaList);
        return "yes_leaves_list";
    }
    @RequestMapping("/noleaveList.do")
    public String noleaveList(@RequestParam("status")String status){
        List<Lea> noLeaList=leaService.getLeasByStatus(status);
        session.setAttribute("noLeaList",noLeaList);
        return "no_leaves_list";
    }
}

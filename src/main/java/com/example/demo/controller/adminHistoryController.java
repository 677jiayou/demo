package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.DepartmentServiceImpl;
import com.example.demo.service.HistoryServiceImpl;
import com.example.demo.service.MoveServiceImpl;
import com.example.demo.service.PositionServiceImpl;
import com.example.demo.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin
public class adminHistoryController {
    @Autowired
    private HistoryServiceImpl historyService;
    @Autowired
    private HttpSession session;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private MoveServiceImpl moveService;

    //所有员工包括离休
    @RequestMapping("/allHistory.do")
    public String allHistory(){
        List<History> histories=historyService.getAllHistory();
        for (History history:histories
             ) {
            history.setDepartment(departmentService.getDepartmentByDepartmentNumber(history.getDepartmentNumber()));
            history.setPosition(positionService.getPositionByPositionNumber(history.getPositionNumber()));
        }
        session.setAttribute("histories",histories);
        return "history_list";
    }
    //离休员工
    @RequestMapping("/History.do")
    public String list(){
        List<History> hList = historyService.selectList();
        for (History history:hList
                ) {
            history.setDepartment(departmentService.getDepartmentByDepartmentNumber(history.getDepartmentNumber()));
            history.setPosition(positionService.getPositionByPositionNumber(history.getPositionNumber()));
        }
        session.setAttribute("hList",hList);
        return "history_record_list";
    }

    @RequestMapping("/allMove.do")
    public  String allMove(){
        List<Move> moveList=moveService.getAllMoves();
        session.setAttribute("moveList",moveList);
        return "move_list";
    }

    // 离职员工个人信息页面映射处理
    @GetMapping("/historyDetail.do")
    public String toDetail(@RequestParam("employeeNumber") Integer employeeNumber) {
        History history = historyService.getHistoryByEmployeeNumber(employeeNumber);
        session.setAttribute("history", history);
        System.out.println(history);
        return "history_detail";
    }

    // 离职员工个人信息修改页面映射处理
    @GetMapping("/history_update.do")
    public String toUpdate(@RequestParam("employeeNumber") Integer employeeNumber) {
        History history = historyService.getHistoryByEmployeeNumber(employeeNumber);
        session.setAttribute("history", history);
        return "history_update";
    }
    // 离职员工个人信息修改表单处理映射处理
    @PostMapping("/historyUpdate.do")
    public ModelAndView historyUpdateModelAndView (@ModelAttribute(value = "History") History history, @ModelAttribute(value = "date") String date) {
        history.setBirthday(MTimeUtil.stringParse(date));
        historyService.updateHistory(history);
        return new ModelAndView("redirect:/allHistory.do");

    }
}

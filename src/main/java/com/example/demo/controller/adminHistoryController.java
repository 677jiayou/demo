package com.example.demo.controller;

import com.example.demo.entity.History;
import com.example.demo.entity.Move;
import com.example.demo.service.DepartmentServiceImpl;
import com.example.demo.service.HistoryServiceImpl;
import com.example.demo.service.MoveServiceImpl;
import com.example.demo.service.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

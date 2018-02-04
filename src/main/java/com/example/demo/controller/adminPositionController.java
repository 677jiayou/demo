package com.example.demo.controller;

import com.example.demo.entity.Position;
import com.example.demo.service.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin
public class adminPositionController {

    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private HttpSession session;


    @RequestMapping("/positionList.do")
    public String departmentList(){
        List<Position> positionList=positionService.getAllPositionInfo();
        session.setAttribute("positionList",positionList);
        return "position_list";
    }
}

package com.example.demo.controller;

import com.example.demo.entity.Position;
import com.example.demo.service.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin
public class adminPositionController {

    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private HttpSession session;

    //职称列表显示
    @RequestMapping("/positionList.do")
    public String departmentList(){

        List<Position> positionList=positionService.getAllPositionInfo();
        session.setAttribute("positionList",positionList);
        return "position_list";
    }
    //去到新增职称页面
    @GetMapping("/toAddPosition.do")
    public  String toAddPosition(){
        Integer maxPositionNumber=positionService.getMaxPositionNumber()+1;
        session.setAttribute("maxPositionNumber",maxPositionNumber);
        return "position_add";
    }

    //职称新增页面表单提交处理映射
    @PostMapping("/addPosition.do")
    public ModelAndView addPosition(@ModelAttribute(value = "Position")Position position){

        positionService.saveNewPosition(position);
        return new ModelAndView("redirect:/positionList.do");

    }
    //去更新职称页面
    @GetMapping("/toUpdatePosition.do")
    public String toUpdatePosition(@RequestParam("positionNumber")Integer positionNumber){
        Position position=positionService.getPositionByPositionNumber(positionNumber);
        session.setAttribute("position",position);
        return "position_update";
    }
    //更新职称信息
    @PostMapping("/updatePosition.do")
    public ModelAndView updatePosition(@ModelAttribute(value = "Position")Position position){

        positionService.updatePosition(position);
        return new ModelAndView("redirect:/positionList.do");

    }

    //删除职称信息
    @GetMapping("/deletePosition.do")
    public ModelAndView deletePosition(@RequestParam("positionNumber")Integer positionNumber){

        positionService.deletePositionByPositionNumber(positionNumber);
        return new ModelAndView("redirect:/positionList.do");

    }
}

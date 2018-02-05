package com.example.demo.service;

import com.example.demo.entity.History;

import java.util.List;

public interface IHistoryService {
    //所有员工档案信息全查
    List<History> getAllHistory();
    //根据员工号查询退休信息
    History getHistoryByEmployeeNumber(Integer employeeNumber);
    //在职员工档案信息查询
    List<History> selectList();
    //保存员工档案信息
    boolean saveHistory(History history);
    //修改员工档案
    boolean updateHistory(History history);
}

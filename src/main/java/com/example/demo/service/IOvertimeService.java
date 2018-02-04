package com.example.demo.service;

import com.example.demo.entity.Overtime;

import java.util.List;

public interface IOvertimeService {
    //所有员工加班信息全查
    List<Overtime> getAllOverTime();
    //根据员工号查询加班信息
    List<Overtime> getOvertiomByEmployeeNumber(Integer employeeNumber);
}

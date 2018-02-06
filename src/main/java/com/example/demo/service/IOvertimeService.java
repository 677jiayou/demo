package com.example.demo.service;

import com.example.demo.entity.Overtime;

import java.util.List;

public interface IOvertimeService {
    //所有员工加班信息全查
    List<Overtime> getAllOverTime();
    //根据员工号查询加班信息
    List<Overtime> getOvertiomByEmployeeNumber(Integer employeeNumber);
    //插入加班信息
    boolean saveOvertime(Overtime overtime);
    //根据id查询加班信息
    Overtime getOvertimeById(Integer id);
    //加班信息修改
    boolean updateOvertime(Overtime overtime,Integer id);
    //根据id删除加班信息
    boolean deleteOvertime(Integer id);
}

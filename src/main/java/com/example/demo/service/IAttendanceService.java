package com.example.demo.service;

import com.example.demo.entity.Attendance;

import java.util.List;

public interface IAttendanceService {
    //请假表全查
    List<Attendance> getAllAttendance();
    //根据员工号查请假信息
    List<Attendance> getAttendanceByEmployeeNum(Integer employee_number);


    //上班签到
    void addStart(Integer employeeNumber);


    //下班签到
    void addEnd(Integer employeeNumber);




}

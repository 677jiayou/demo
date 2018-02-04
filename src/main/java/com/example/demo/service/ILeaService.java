package com.example.demo.service;

import com.example.demo.entity.Lea;

import java.util.List;

public interface ILeaService {

    //请假记录全查
    List<Lea> getAllLeas();
    //根据员工号查询请假记录
    List<Lea> getLeasByaEmployeeNumber(Integer employeeNumber);

}

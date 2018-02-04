package com.example.demo.service;

import com.example.demo.entity.Department;

import java.util.List;

public interface IDepartmentService {

    //获取所有部门信息
    List<Department> getAllDepartmentInfo();
    //根据部门编号获取所在部门信息
    Department getDepartmentByDepartmentNumber(Integer departmentNumber);
}

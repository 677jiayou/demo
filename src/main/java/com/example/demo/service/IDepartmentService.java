package com.example.demo.service;

import com.example.demo.entity.Department;

import java.util.List;

public interface IDepartmentService {

    //获取所有部门信息
    List<Department> getAllDepartmentInfo();
    //根据部门编号获取所在部门信息
    Department getDepartmentByDepartmentNumber(Integer departmentNumber);
    //更新部门信息
    boolean updateDepartment(Department department);
    //查询部门编号的最大值
    Integer getMaxdepartmentNumber();
    //新增部门信息
    boolean saveNewDepartment(Department department);
    //删除部门信息
    boolean deleteDepartment(Integer departmentNumber);
}

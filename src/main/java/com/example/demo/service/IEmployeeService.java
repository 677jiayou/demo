package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    //员工信息全查
    List<Employee> findAllEmployee();
    //根据id查询员工信息
    Employee findEmployeeById(Integer id);
    //根据员工号和密码查询员工信息
    Employee findEmployeeByNumAndPassword(Integer userName,String password);
    //修改员工信息
    boolean updateEmployee(Employee employee);
    //根据工号查询员工信息
    Employee findEmployeeByEmployeeNumber(Integer employeeNumber);
    //查询员工号的最大值
    Integer maxEmployeeNumber();
    //保存员工信息
    boolean saveNewEmployee(Employee employee);
    //删除员工信息
    Integer deleteEmployee(Integer employeeNumber);
    //模糊查询
    List<Employee> getEmployeesByInput(String input);
}

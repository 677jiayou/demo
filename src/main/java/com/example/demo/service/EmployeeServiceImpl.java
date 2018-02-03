package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repostry.EmployeeMapper;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList=employeeMapper.findAll();
        return employeeList;
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee=employeeMapper.findOne(id);
        return employee;
    }

    @Override
    public Employee findEmployeeByNumAndPassword(Integer userName, String password) {
        Employee employee=employeeMapper.findEmployeeByEmployeeNumberAndPassword(userName,password);

        return employee;
    }
}

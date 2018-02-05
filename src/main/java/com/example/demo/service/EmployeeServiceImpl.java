package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repostry.DepartmentMapper;
import com.example.demo.repostry.EmployeeMapper;
import com.example.demo.repostry.PositionMapper;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList=employeeMapper.findAll();
        for (Employee employee:employeeList
             ) {
            employee.setPosition(positionMapper.findPositionByPositionNumber(employee.getPositionNumber()));
            employee.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(employee.getDepartmentNumber()));
        }
        return employeeList;
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee=employeeMapper.findOne(id);
        employee.setPosition(positionMapper.findPositionByPositionNumber(employee.getPositionNumber()));
        employee.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(employee.getDepartmentNumber()));
        return employee;
    }

    @Override
    public Employee findEmployeeByNumAndPassword(Integer userName, String password) {
        Employee employee=employeeMapper.findEmployeeByEmployeeNumberAndPassword(userName,password);
        employee.setPosition(positionMapper.findPositionByPositionNumber(employee.getPositionNumber()));
        employee.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(employee.getDepartmentNumber()));
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try {
            Employee employee1=employeeMapper.findEmployeeByEmployeeNumber(employee.getEmployeeNumber());
            employee1.setName(employee.getName());
            employee1.setPassword(employee.getPassword());
            employee1.setGender(employee.getGender());
            employee1.setBirthday(employee.getBirthday());
            employee1.setTelephone(employee.getTelephone());
            employee1.setEmail(employee.getEmail());
            employee1.setAddress(employee.getAddress());
            employee1.setEducation(employee.getEducation());
            employee1.setNotes(employee.getNotes());
            employeeMapper.saveAndFlush(employee1);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Employee findEmployeeByEmployeeNumber(Integer employeeNumber) {
        Employee employee=employeeMapper.findEmployeeByEmployeeNumber(employeeNumber);
        employee.setPosition(positionMapper.findPositionByPositionNumber(employee.getPositionNumber()));
        employee.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(employee.getDepartmentNumber()));
        return  employee;
    }
}

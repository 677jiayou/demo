package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repostry.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartmentInfo() {
        List<Department> departmentList=departmentMapper.findAll();
        return departmentList;
    }

    @Override
    public Department getDepartmentByDepartmentNumber(Integer departmentNumber) {
        Department department=departmentMapper.findDepartmentByDepartmentNumber(departmentNumber);
        return department;
    }

    @Override
    public boolean updateDepartment(Department department) {
        try {
            Department department1=departmentMapper.findDepartmentByDepartmentNumber(department.getDepartmentNumber());
            department1.setAddress(department.getAddress());
            department1.setTelephone(department.getTelephone());
            department1.setName(department.getName());
            department1.setNotes(department.getNotes());
            departmentMapper.saveAndFlush(department1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer getMaxdepartmentNumber() {
        return departmentMapper.getMaxDepartmentNumber();
    }

    @Override
    public boolean saveNewDepartment(Department department) {
        try {
            departmentMapper.save(department);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDepartment(Integer departmentNumber) {
        try {
            departmentMapper.deleteDepartmentByDepartmentNumber(departmentNumber);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

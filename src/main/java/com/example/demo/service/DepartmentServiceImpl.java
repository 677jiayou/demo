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
}

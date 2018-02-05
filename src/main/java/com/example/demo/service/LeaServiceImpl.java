package com.example.demo.service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Lea;
import com.example.demo.repostry.DepartmentMapper;
import com.example.demo.repostry.EmployeeMapper;
import com.example.demo.repostry.LeaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class LeaServiceImpl implements ILeaService {


    @Autowired
    private LeaMapper leaMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Lea> getAllLeas() {
        List<Lea> leaList=leaMapper.findAll();
        for (Lea lea:leaList
                ) {
            lea.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(lea.getDepartmentNumber()));
            lea.setEmployee(employeeMapper.findEmployeeByEmployeeNumber(lea.getEmployeeNumber()));
        }
        return leaList;
    }

    @Override
    public List<Lea> getLeasByaEmployeeNumber(Integer employeeNumber) {
        List<Lea> leaList=leaMapper.findLeasByEmployeeNumber(employeeNumber);
        for (Lea lea:leaList
                ) {
            lea.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(lea.getDepartmentNumber()));
            lea.setEmployee(employeeMapper.findEmployeeByEmployeeNumber(lea.getEmployeeNumber()));
        }
        return leaList;
    }

    @Override
    public List<Lea> getLeasByStatus(String status) {
        List<Lea> leaList=leaMapper.findLeasByStatus(status);
        for (Lea lea:leaList
                ) {
            lea.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(lea.getDepartmentNumber()));
            lea.setEmployee(employeeMapper.findEmployeeByEmployeeNumber(lea.getEmployeeNumber()));
        }
        return leaList;
    }

    @Override
    public boolean saveLea(Lea lea) {
        try {
            leaMapper.save(lea);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

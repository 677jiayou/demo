package com.example.demo.service;

import com.example.demo.entity.Overtime;
import com.example.demo.repostry.DepartmentMapper;
import com.example.demo.repostry.EmployeeMapper;
import com.example.demo.repostry.OvertimeMapper;
import com.example.demo.repostry.PositionMapper;
import com.example.demo.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class OvertimeServiceImpl implements IOvertimeService {

    @Autowired
    private OvertimeMapper overtimeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Overtime> getAllOverTime() {
        List<Overtime> overtimeList=overtimeMapper.findAll();
        for (Overtime overtime:overtimeList
                ) {
            overtime.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(overtime.getDepartmentNumber()));
            overtime.setEmployee(employeeMapper.findEmployeeByEmployeeNumber(overtime.getEmployeeNumber()));
            String day=MTimeUtil.dateFormat(overtime.getDay());
            overtime.setDay1(day);
            String startTime=MTimeUtil.dateFormat(overtime.getStartTime());
            overtime.setStart(startTime);
            String endTime=MTimeUtil.dateFormat(overtime.getEndTime());
            overtime.setEnd(endTime);
        }
        return overtimeList;
    }

    @Override
    public List<Overtime> getOvertiomByEmployeeNumber(Integer employeeNumber) {
        List<Overtime> overtimeList=overtimeMapper.findOvertimesByEmployeeNumber(employeeNumber);
        for (Overtime overtime:overtimeList
             ) {
            overtime.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(overtime.getDepartmentNumber()));
            overtime.setEmployee(employeeMapper.findEmployeeByEmployeeNumber(overtime.getEmployeeNumber()));
            String day=MTimeUtil.dateFormat(overtime.getDay());
            overtime.setDay1(day);
            String startTime=MTimeUtil.dateFormat(overtime.getStartTime());
            overtime.setStart(startTime);
            String endTime=MTimeUtil.dateFormat(overtime.getEndTime());
            overtime.setEnd(endTime);
        }
        return overtimeList;
    }

    @Override
    public boolean saveOvertime(Overtime overtime) {

        try {
            overtimeMapper.save(overtime);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public Overtime getOvertimeById(Integer id) {
        Overtime overtime=overtimeMapper.findOne(id);
        String day=MTimeUtil.dateFormat(overtime.getDay());
        overtime.setDay1(day);
        String startTime=MTimeUtil.dateFormat(overtime.getStartTime());
        overtime.setStart(startTime);
        String endTime=MTimeUtil.dateFormat(overtime.getEndTime());
        overtime.setEnd(endTime);
        return overtime;
    }

    @Override
    public boolean updateOvertime(Overtime overtime,Integer id) {
        try {
            overtime.setId(id);
            overtimeMapper.saveAndFlush(overtime);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteOvertime(Integer id) {
        try {
            overtimeMapper.deleteOvertimeById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }
}

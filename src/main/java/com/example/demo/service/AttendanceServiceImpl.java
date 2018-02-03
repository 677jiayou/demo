package com.example.demo.service;

import com.example.demo.entity.Attendance;
import com.example.demo.repostry.AttendanceMapper;
import com.example.demo.repostry.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class AttendanceServiceImpl implements IAttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Attendance> getAllAttendance() {
        List<Attendance> attendanceList=attendanceMapper.findAll();
        return null;
    }

    @Override
    public List<Attendance> getAttendanceByEmployeeNum(Integer employee_number) {
        List<Attendance> attendanceList=attendanceMapper.findAttendancesByEmployeeNumber(employee_number);
        for (Attendance attendance:attendanceList
             ) {
            attendance.setEmployee(employeeMapper.findEmployeeByEmployeeNumber(employee_number));
        }
        return attendanceList;
    }
}

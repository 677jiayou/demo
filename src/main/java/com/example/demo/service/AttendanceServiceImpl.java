package com.example.demo.service;

import com.example.demo.entity.Attendance;
import com.example.demo.repostry.AttendanceMapper;
import com.example.demo.repostry.EmployeeMapper;
import com.example.demo.util.MConstant;
import com.example.demo.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class AttendanceServiceImpl implements IAttendanceService {


    //获取相关时间
    Date amTime = MTimeUtil.stringTimeParse(MConstant.AMTime);
    Date amStartTime = MTimeUtil.stringTimeParse(MConstant.AMStartTime);
    Date amEndTime = MTimeUtil.stringTimeParse(MConstant.AMEndTime);
    Date pmTime = MTimeUtil.stringTimeParse(MConstant.PMTime);
    Date pmStartTime = MTimeUtil.stringTimeParse(MConstant.PMStartTime);
    Date pmEndTime = MTimeUtil.stringTimeParse(MConstant.PMEndTime);
    Date ovTime = MTimeUtil.stringTimeParse(MConstant.OVTime);
    Date ovStartTime = MTimeUtil.stringTimeParse(MConstant.OVStartTime);
    Date ovEndTime = MTimeUtil.stringTimeParse(MConstant.OVEndTime);

    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Attendance> getAllAttendance() {
        List<Attendance> attendanceList=attendanceMapper.findAll();
        for (Attendance attendance:attendanceList
                ) {
            attendance.setEmployee(employeeMapper.findEmployeeByEmployeeNumber(attendance.getEmployeeNumber()));
            String startTime = MTimeUtil.timeFormat(attendance.getStartTime());
            attendance.setStart(startTime);
            String endTime = MTimeUtil.timeFormat(attendance.getEndTime());
            attendance.setEnd(endTime);
            String day=MTimeUtil.dateFormat(attendance.getDay());
            attendance.setDay1(day);

        }
        return attendanceList;
    }

    @Override
    public List<Attendance> getAttendanceByEmployeeNum(Integer employee_number) {
        List<Attendance> attendanceList=attendanceMapper.findAttendancesByEmployeeNumber(employee_number);
        for (Attendance attendance:attendanceList
             ) {
            attendance.setEmployee(employeeMapper.findEmployeeByEmployeeNumber(employee_number));
            String startTime = MTimeUtil.timeFormat(attendance.getStartTime());
            attendance.setStart(startTime);
            String endTime = MTimeUtil.timeFormat(attendance.getEndTime());
            attendance.setEnd(endTime);
            String day=MTimeUtil.dateFormat(attendance.getDay());
            attendance.setDay1(day);
        }
        return attendanceList;
    }



    @Override
    public void addStart(Integer employeeNumber){
        //获取当前时间
        Date nowTime = MTimeUtil.nowTime();
        //获取当前日期
        Date nowDate = MTimeUtil.nowDate();
        Attendance attendance = new Attendance();
        attendance.setEmployeeNumber(employeeNumber);
        attendance.setDay(nowDate);
        attendance.setStartTime(nowTime);
        System.out.println(nowDate);
        System.out.println(nowTime);
        if (nowTime.after(amTime) && nowTime.before(amEndTime)) {
            Attendance att = attendanceMapper.findAttendanceByDayAndEmployeeNumberAndTimeType(nowDate,employeeNumber, "上午");
            if (att == null) {
                attendance.setTimeType("上午");
                if (nowTime.before(amStartTime)) {
                    attendance.setStartType("正常");
                }else{
                    attendance.setStartType("迟到");
                }
                attendanceMapper.save(attendance);
            }
        }else if(nowTime.after(pmTime) && nowTime.before(pmEndTime)){
            Attendance att = attendanceMapper.findAttendanceByDayAndEmployeeNumberAndTimeType(nowDate,employeeNumber, "下午");

            if (att == null) {
                attendance.setTimeType("下午");
                if (nowTime.before(pmStartTime)) {
                    attendance.setStartType("正常");
                }else{
                    attendance.setStartType("迟到");
                }
                attendanceMapper.save(attendance);
            }
        }else if(nowTime.after(ovTime) && nowTime.before(ovEndTime)){
            Attendance att = attendanceMapper.findAttendanceByDayAndEmployeeNumberAndTimeType(nowDate,employeeNumber, "加班");
            if (att == null) {
                attendance.setTimeType("加班");
                if (nowTime.before(ovStartTime)) {
                    attendance.setStartType("正常");
                }else{
                    attendance.setStartType("迟到");
                }
                attendanceMapper.save(attendance);
            }
        }
    }

    @Override
    public void addEnd(Integer employeeNumber) {
        Date nowTime = MTimeUtil.nowTime();
        Date nowDate = MTimeUtil.nowDate();
        if (nowTime.after(amStartTime) && nowTime.before(pmStartTime)) {
            Attendance attendance = attendanceMapper.findAttendanceByDayAndEmployeeNumberAndTimeType(nowDate,employeeNumber, "上午");

            if (attendance.getEndTime() == null) {
                attendance.setEndTime(nowTime);
                if (nowTime.after(amEndTime)) {
                    attendance.setEndType("正常");
                }else{
                    attendance.setEndType("早退");
                }
                attendanceMapper.saveAndFlush(attendance);
            }
        }else if(nowTime.after(pmStartTime) && nowTime.before(ovStartTime)){
            Attendance attendance = attendanceMapper.findAttendanceByDayAndEmployeeNumberAndTimeType(nowDate,employeeNumber, "下午");

            if (attendance.getEndTime() == null) {
                attendance.setEndTime(nowTime);
                if (nowTime.after(pmEndTime)) {
                    attendance.setEndType("正常");
                }else{
                    attendance.setEndType("早退");
                }
                attendanceMapper.saveAndFlush(attendance);
            }
        }else if(nowTime.after(ovStartTime)){
            Attendance attendance = attendanceMapper.findAttendanceByDayAndEmployeeNumberAndTimeType(nowDate,employeeNumber, "加班");

            if (attendance.getEndTime() == null) {
                attendance.setEndTime(nowTime);
                if (nowTime.after(ovEndTime)) {
                    attendance.setEndType("正常");
                }else{
                    attendance.setEndType("早退");
                }
                attendanceMapper.saveAndFlush(attendance);

            }
        }
    }

}

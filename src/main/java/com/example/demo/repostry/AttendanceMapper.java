package com.example.demo.repostry;

import com.example.demo.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Transactional
public interface AttendanceMapper extends JpaRepository<Attendance,Integer> {

    List<Attendance> findAttendancesByEmployeeNumber(Integer employee_number);


    Attendance findAttendanceByDayAndEmployeeNumberAndTimeType(Date date,Integer employeeNumber,String timeType);
}

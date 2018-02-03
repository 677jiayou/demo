package com.example.demo.repostry;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface EmployeeMapper extends JpaRepository<Employee,Integer> {

    Employee findEmployeeByEmployeeNumberAndPassword(@Param("employeeNumber")Integer employeeNumber, @Param("password")String password);

    Employee findEmployeeByEmployeeNumber(@Param("employeeNumber")Integer employeeNumber);
}

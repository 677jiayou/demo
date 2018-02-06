package com.example.demo.repostry;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeMapper extends JpaRepository<Employee,Integer> ,JpaSpecificationExecutor<EmployeeMapper> {

    Employee findEmployeeByEmployeeNumberAndPassword(@Param("employeeNumber")Integer employeeNumber, @Param("password")String password);

    Employee findEmployeeByEmployeeNumber(@Param("employeeNumber")Integer employeeNumber);

    //这里不要用表名
    @Query("select max(bean.employeeNumber) from Employee bean")
    Integer findMaxEmployeeNumber();

    Integer deleteEmployeeByEmployeeNumber(Integer employeeNumber);


    @Query("select e from Employee e where e.name like ?1")
    List<Employee> findEmployeeByInput(String input);

}

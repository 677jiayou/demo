package com.example.demo.repostry;


import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface DepartmentMapper extends JpaRepository<Department,Integer> {
    Department findDepartmentByDepartmentNumber(@Param("departmentNumber")Integer departmentNumber);
}

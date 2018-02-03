package com.example.demo.repostry;

import com.example.demo.entity.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OvertimeMapper extends JpaRepository<Overtime,Integer> {

    List<Overtime> findOvertimesByEmployeeNumber(Integer employeeNumber);
}

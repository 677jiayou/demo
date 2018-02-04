package com.example.demo.repostry;

import com.example.demo.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface HistoryMapper extends JpaRepository<History,Integer> {

    History findHistoryByEmployeeNumber(Integer employeeNumber);
}

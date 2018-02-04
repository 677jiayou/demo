package com.example.demo.repostry;

import com.example.demo.entity.Lea;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LeaMapper extends JpaRepository<Lea,Integer> {

    List<Lea> findLeasByEmployeeNumber(Integer employeeNumber);

    List<Lea> findLeasByStatus(String status);
}

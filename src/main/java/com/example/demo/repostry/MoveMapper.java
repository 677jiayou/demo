package com.example.demo.repostry;

import com.example.demo.entity.Move;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface MoveMapper extends JpaRepository<Move,Integer> {

}

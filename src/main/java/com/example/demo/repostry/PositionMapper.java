package com.example.demo.repostry;

import com.example.demo.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface PositionMapper extends JpaRepository<Position,Integer> {
    Position findPositionByPositionNumber(@Param("positionNumber") Integer positionNumber);

    @Query("select max(position.positionNumber) from Position  position")
    Integer getMaxpositionNumber();

    boolean deletePositionByPositionNumber(Integer positionNumber);
}

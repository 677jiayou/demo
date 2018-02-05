package com.example.demo.service;

import com.example.demo.entity.Position;
import com.example.demo.repostry.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jnlp.PersistenceService;
import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<Position> getAllPositionInfo() {
        List<Position> positionList=positionMapper.findAll();
        return positionList;
    }

    @Override
    public Position getPositionByPositionNumber(Integer positionNumber) {
        Position position=positionMapper.findPositionByPositionNumber(positionNumber);
        return position;
    }

    @Override
    public Integer getMaxPositionNumber() {
        return positionMapper.getMaxpositionNumber();
    }

    @Override
    public boolean deletePositionByPositionNumber(Integer positionNumber) {
        try {
            positionMapper.deletePositionByPositionNumber(positionNumber);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePosition(Position position) {
        try {
            Position position1=positionMapper.findPositionByPositionNumber(position.getPositionNumber());
            position1.setName(position.getName());
            position1.setLevel(position.getLevel());
            position1.setNotes(position.getNotes());
            position1.setPositionNumber(position.getPositionNumber());
            positionMapper.saveAndFlush(position1);
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveNewPosition(Position position) {
        try {
            positionMapper.save(position);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

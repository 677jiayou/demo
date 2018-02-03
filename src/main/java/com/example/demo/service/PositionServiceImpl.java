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
}

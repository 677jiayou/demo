package com.example.demo.service;

import com.example.demo.entity.Position;

import java.util.List;

public interface IPositionService {

    //获取职位信息
    List<Position> getAllPositionInfo();
    //根据职位编号获取职位信息
    Position getPositionByPositionNumber(Integer positionNumber);
}

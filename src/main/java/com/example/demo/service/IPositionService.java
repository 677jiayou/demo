package com.example.demo.service;

import com.example.demo.entity.Position;

import java.util.List;

public interface IPositionService {

    //获取职位信息
    List<Position> getAllPositionInfo();
    //根据职位编号获取职位信息
    Position getPositionByPositionNumber(Integer positionNumber);
    //获取职称编号的最大值
    Integer getMaxPositionNumber();
    //删除职称信息
    boolean deletePositionByPositionNumber(Integer positionNumber);
    //修改职称信息
    boolean updatePosition(Position position);
    //新增职称信息
    boolean saveNewPosition(Position position);
}

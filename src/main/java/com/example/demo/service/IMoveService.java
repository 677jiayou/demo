package com.example.demo.service;

import com.example.demo.entity.Move;

import java.util.List;

public interface IMoveService {
    //全查员工调动信息
    List<Move> getAllMoves();
}

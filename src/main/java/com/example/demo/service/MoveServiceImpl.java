package com.example.demo.service;

import com.example.demo.entity.Move;
import com.example.demo.repostry.DepartmentMapper;
import com.example.demo.repostry.EmployeeMapper;
import com.example.demo.repostry.MoveMapper;
import com.example.demo.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class MoveServiceImpl implements IMoveService {

    @Autowired
    private MoveMapper moveMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Move> getAllMoves() {
        List<Move> moveList=moveMapper.findAll();
        for (Move move:moveList
             ) {
            move.setDepartment2(departmentMapper.findDepartmentByDepartmentNumber(move.getAfter()));
            move.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(move.getBefore()));
            move.setEmployee(employeeMapper.findEmployeeByEmployeeNumber(move.getEmployeeNumber()));
            String time=MTimeUtil.dateFormat(move.getTime());
            move.setTime1(time);
        }
        return moveList;
    }
}

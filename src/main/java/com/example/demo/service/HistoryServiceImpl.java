package com.example.demo.service;

import com.example.demo.entity.History;
import com.example.demo.repostry.DepartmentMapper;
import com.example.demo.repostry.HistoryMapper;
import com.example.demo.repostry.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class HistoryServiceImpl implements IHistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Override
    public List<History> getAllHistory() {
        return historyMapper.findAll();
    }

    @Override
    public History getHistoryByEmployeeNumber(Integer employeeNumber) {
        History history= historyMapper.findHistoryByEmployeeNumber(employeeNumber);
        history.setPosition(positionMapper.findPositionByPositionNumber(history.getPositionNumber()));
        history.setDepartment(departmentMapper.findDepartmentByDepartmentNumber(history.getDepartmentNumber()));
        return history;
    }

    @Override
    public List<History> selectList() {
        List<History> histories=historyMapper.findAll();
        List<History> nowHistories=new ArrayList<>();
        for (History history:histories
             ) {
            if (history.getOutTime()!=null){
                nowHistories.add(history);
            }
        }

        return nowHistories;
    }

    @Override
    public boolean saveHistory(History history) {
        try {
            historyMapper.save(history);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateHistory(History history) {
        try {
            History history1=historyMapper.findHistoryByEmployeeNumber(history.getEmployeeNumber());
            history1.setName(history.getName());
            history1.setGender(history.getGender());
            history1.setBirthday(history.getBirthday());
            history1.setEmail(history.getEmail());
            history1.setTelephone(history.getTelephone());
            history1.setAddress(history.getAddress());
            history1.setHome(history.getHome());
            history1.setEducation(history.getEducation());
            history1.setNotes(history.getNotes());
            history1.setStatus("在职");
            historyMapper.saveAndFlush(history1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

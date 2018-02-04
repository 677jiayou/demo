package com.example.demo.service;

import com.example.demo.entity.History;
import com.example.demo.repostry.HistoryMapper;
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

    @Override
    public List<History> getAllHistory() {
        return historyMapper.findAll();
    }

    @Override
    public History getHistoryByEmployeeNumber(Integer employeeNumber) {
        return historyMapper.findHistoryByEmployeeNumber(employeeNumber);
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
}

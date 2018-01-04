package com.lv.basui.service.impl;

import com.lv.basui.dao.DateDao;
import com.lv.basui.entity.RemainingDays;
import com.lv.basui.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private DateDao dateDao;

    @Override
    public RemainingDays getdays(String type){
        return dateDao.queryDate(type);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateDaysMsg(RemainingDays days){
       return dateDao.updateDayMsg(days.getId());
    }


}

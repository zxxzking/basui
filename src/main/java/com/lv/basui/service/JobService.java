package com.lv.basui.service;

import com.lv.basui.entity.RemainingDays;
import org.springframework.transaction.annotation.Transactional;

public interface JobService {

    RemainingDays getdays(String type);

    @Transactional(rollbackFor = Exception.class)
    int updateDaysMsg(RemainingDays days);
}

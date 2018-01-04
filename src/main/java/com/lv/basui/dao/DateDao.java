package com.lv.basui.dao;

import com.lv.basui.entity.RemainingDays;

public interface DateDao {
    RemainingDays queryDate(String type);

    int updateDayMsg(Integer id);
}

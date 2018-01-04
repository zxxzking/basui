package com.lv.basui.dao.impl;

import com.lv.basui.dao.DateDao;
import com.lv.basui.entity.RemainingDays;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Repository
public class DateDaoImpl extends BaseDao implements DateDao {



    @Override
    public RemainingDays queryDate(String type){
        String sql = "select * from remaining_day where days_type = ? and isactive = '1'";
        RemainingDays day = dbHelper.queryForObject(sql, RemainingDays.class, type);
        return day;
    }


    @Override
    public int updateDayMsg(Integer id){
        String sql = "update remaining_day set days = days-1 where id = ? and isactive = '1'";
        return dbHelper.execute(sql,id);
    }

}

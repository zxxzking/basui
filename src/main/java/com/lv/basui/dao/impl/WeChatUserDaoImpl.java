package com.lv.basui.dao.impl;

import com.lv.basui.dao.WeChatUserDao;
import com.lv.basui.entity.Laxi;
import com.lv.basui.entity.Meal;
import com.lv.basui.entity.WeChatInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WeChatUserDaoImpl extends BaseDao implements WeChatUserDao {

    @Override
    public WeChatInfo isExist(String openId){
        String sql = "select * from weChat_info where openId = ?";
        return dbHelper.queryForObject(sql, WeChatInfo.class,openId);
    }

    @Override
    public Long saveUserInfo(WeChatInfo info){
        Long id = generatorKey("weChat_info");
        info.setId(id);
        dbHelper.insert(info);

        return id;
    }

    @Override
    public boolean updateUserInfo(WeChatInfo info){
        return dbHelper.updateById(info);
    }


    @Override
    public Meal queryUserMeal(Long userId,String mealType){
        String sql = "select * from meal where userId = ? and type = ? and isactive = '1' and DATE_FORMAT(inserttime,'%Y-%m-%d') = current_date";

        return dbHelper.queryForObject(sql,Meal.class,userId,mealType);


    }

    @Override
    public Laxi queryUserLaxi(Long userId){
        String sql = "select * from laxi where userId = ? and isactive = '1' and DATE_FORMAT(inserttime,'%Y-%m-%d') = current_date ";


        return dbHelper.queryForObject(sql,Laxi.class,userId);
    }


    @Override
    public List<Meal> queryTodayMeal(Long userId){
        String sql = "SELECT * FROM meal WHERE userId = ? AND DATE_FORMAT(inserttime,'%Y-%m-%d') = CURRENT_DATE and isactive = '1'";


        return  dbHelper.list(sql,Meal.class,userId);
    }




}

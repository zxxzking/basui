package com.lv.basui.dao;

import com.lv.basui.entity.Laxi;
import com.lv.basui.entity.Meal;
import com.lv.basui.entity.WeChatInfo;

import java.util.List;

public interface WeChatUserDao {
    WeChatInfo isExist(String openId);

    Long saveUserInfo(WeChatInfo info);

    boolean updateUserInfo(WeChatInfo info);

    Meal queryUserMeal(Long userId, String mealType);

    Laxi queryUserLaxi(Long userId);

    List<Meal> queryTodayMeal(Long userId);
}

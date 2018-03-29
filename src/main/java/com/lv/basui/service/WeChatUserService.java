package com.lv.basui.service;

import com.lv.basui.dto.MealDto;
import com.lv.basui.dto.ResultBean;
import com.lv.basui.entity.WeChatInfo;
import org.springframework.transaction.annotation.Transactional;

public interface WeChatUserService {
    @Transactional(rollbackFor = Exception.class)
    String initUser(WeChatInfo info);

    @Transactional(rollbackFor = Exception.class)
    ResultBean saveMealInfo(ResultBean resultBean, String meal, String type, String userId);

    MealDto queryTodayMeal(String userId);

    void recordLaxiStatus(String userId, String status);
}

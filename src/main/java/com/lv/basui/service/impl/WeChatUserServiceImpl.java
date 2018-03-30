package com.lv.basui.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.lv.basui.dao.WeChatUserDao;
import com.lv.basui.dto.EnumTest;
import com.lv.basui.dto.MealDto;
import com.lv.basui.dto.ResultBean;
import com.lv.basui.entity.Laxi;
import com.lv.basui.entity.Meal;
import com.lv.basui.entity.WeChatInfo;
import com.lv.basui.service.TokenService;
import com.lv.basui.service.WeChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WeChatUserServiceImpl implements WeChatUserService {

    @Autowired
    private WeChatUserDao weChatUserDao;

    @Autowired
    private DbHelper dbHelper;


    @Autowired
    private TokenService tokenService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String initUser(WeChatInfo info){
        Long userId = null;
        String openid = info.getOpenid();
        WeChatInfo weChatInfo = weChatUserDao.isExist(openid);
        if(null == weChatInfo){
            userId = weChatUserDao.saveUserInfo(info);

        }else{
            weChatUserDao.updateUserInfo(weChatInfo);
            userId = weChatInfo.getId();
        }
        String token = tokenService.createToken(userId);

        return token;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean saveMealInfo(ResultBean resultBean, String meal, String type, String userId){

        Meal meals = weChatUserDao.queryUserMeal(Long.valueOf(userId), type);
        if(null == meals){
            meals = new Meal();
            meals.setUserid(Long.valueOf(userId));
            setMealInfo(meals,type,meal);
            dbHelper.insert(meals);
        }else{
            setMealInfo(meals,type,meal);
            dbHelper.updateById(meals);
        }


        return resultBean;
    }


    private void setMealInfo(Meal meals,String type,String meal){
        switch (type){
            case "0":
                meals.setBreakfast(meal);
                break;
            case "1":
                meals.setLunch(meal);
                break;
            case "2":
                meals.setDinner(meal);
                break;
            case "3":
                meals.setOther(meal);
                break;
        }
    }


    @Override
    public List<MealDto> queryUserMealInfoList(String userId){
        List list = new ArrayList<MealDto>();
        List<Meal> meals = weChatUserDao.queryUserMealInfoList(Long.valueOf(userId));
        for (Meal meal : meals){
            MealDto dto = new MealDto();
            dto.setBreakfast(null == meal.getBreakfast() ? "未记录":meal.getBreakfast());
            dto.setLunch(null == meal.getLunch() ? "未记录":meal.getLunch());
            dto.setDinner(null == meal.getDinner() ? "未记录":meal.getDinner());
            dto.setOther(null == meal.getOther() ? "未记录":meal.getOther());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = format.format(meal.getInserttime());
            dto.setDate(date);
            Laxi laxi = weChatUserDao.queryLaxi(Long.valueOf(userId), date);
            if(null == laxi){
                dto.setLaxiStatus("未记录");
            }else{
                if("1".equals(laxi.getIslaxi())){
                    dto.setLaxiStatus("拉稀了");
                }else{
                    dto.setLaxiStatus("没拉稀");
                }
            }
            list.add(dto);

        }


        return list;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void recordLaxiStatus(String userId, String status){
        Laxi laxi = weChatUserDao.queryUserLaxi(Long.valueOf(userId));
        if(null == laxi){
            laxi = new Laxi();
            laxi.setUserid(Long.valueOf(userId));
            laxi.setIslaxi(status);
            dbHelper.insert(laxi);
        }else{
            laxi.setIslaxi(status);
            dbHelper.updateById(laxi);
        }


    }










}

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
            meals.setMeal(meal);
            meals.setType(type);
            dbHelper.insert(meals);
        }else{
            meals.setUserid(Long.valueOf(userId));
            meals.setMeal(meal);
            meals.setType(type);
            dbHelper.updateById(meals);
        }


        return resultBean;
    }


    @Override
    public MealDto queryTodayMeal(String userId){
        MealDto dto = new MealDto();
        List<Meal> meals = weChatUserDao.queryTodayMeal(Long.valueOf(userId));
        for(Meal meal : meals){
            if("0".equals(meal.getType())){
                dto.setBreakfast(meal.getMeal());
            }
            if("1".equals(meal.getType())){
                dto.setLunch(meal.getMeal());
            }
            if("2".equals(meal.getType())){
                dto.setDinner(meal.getMeal());
            }
            if("3".equals(meal.getType())){
                dto.setOther(meal.getMeal());
            }
        }

        return dto;
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






    public static String GetUrl(String inUrl){
        StringBuilder sb = new StringBuilder();
        try {
            URL url =new URL(inUrl);
            BufferedReader reader =new BufferedReader(new InputStreamReader(url.openStream()));

            String temp="";
            while((temp=reader.readLine())!=null){
                //System.out.println(temp);
                sb.append(temp);
            }
        } catch (MalformedURLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static List<String> GetMatcher(String str, String url){
        List<String> result = new ArrayList<String>();
        Pattern p =Pattern.compile(url);//获取网页地址
        Matcher m =p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
            result.add(m.group());
        }
        return result;
    }


    public static List<String> getMatcher(String s){
        Pattern p1 =Pattern.compile("<link(([\\s\\S])*?)>");
        Matcher matcher1 = p1.matcher(s);
        List<String> list = new ArrayList<>();
        while (matcher1.find()){
            // System.out.println(matcher1.start()+"  "+matcher1.end());
            System.out.println("匹配<link> 匹配到的字符"+matcher1.group());
            list.add(matcher1.group());
            s = s.replace(matcher1.group(),"");
            matcher1 = p1.matcher(s);
        }

        List<String> list1 = new ArrayList<>();


        Pattern p =Pattern.compile("href=\".*.ico\"");
        Pattern p2 =Pattern.compile("href=\"(([\\s\\S])*?).ico\"");
        for (int i=0; i<list.size();i++){
            Matcher matcher = p2.matcher(list.get(i));
            if(matcher.find()){
                // System.out.println(matcher.start()+"  "+matcher.end());
                System.out.println("匹配.ico匹配到的字符"+matcher.group(0));
                System.out.println(matcher.group(0).replace("href=","").replace("\"",""));
                list1.add(matcher.group(0).replace("href=","").replace("\"",""));
            }

        }
        return list1;
    }


    public static void main(String args[]){
        String str=GetUrl("https://www.cnblogs.com/xiaxianfei/p/5275601.html");
        List<String> ouput =getMatcher(str);

        for(String temp:ouput){
            //System.out.println(ouput.get(0));
            System.out.println(temp);
        }

    }




}

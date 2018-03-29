package com.lv.basui.controller.wechatsupport;

import com.lv.basui.controller.BaseController;
import com.lv.basui.dto.MealDto;
import com.lv.basui.dto.ResultBean;
import com.lv.basui.entity.WeChatInfo;
import com.lv.basui.service.TokenService;
import com.lv.basui.service.WeChatUserService;
import com.lv.basui.utils.HttpToolKit;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping(value = "wechat")
public class WeChatUserInfoController extends BaseController{


    @Autowired
    private WeChatUserService weChatUserService;


    @PostMapping(value = "initUser")
    public ResultBean initUser(@RequestParam(value = "openId",required = true)String openId,
                               @RequestParam(value = "nickName",required = true)String nickName,
                               @RequestParam(value = "avatarUrl",required = true)String avatarUrl){
        ResultBean resultBean = new ResultBean();
        WeChatInfo info = new WeChatInfo();
        info.setAvatarurl(avatarUrl);
        info.setNickName(nickName);
        info.setOpenid(openId);

        String token = weChatUserService.initUser(info);
        resultBean.setData(token);

        return resultBean;
    }

    //  获取当前小时
    @GetMapping(value = "currentTime")
    public ResultBean currentTime(){
        ResultBean resultBean = new ResultBean();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String format = formatter.format(new Date());

        resultBean.setData(format);

        return resultBean;
    }

    @PostMapping(value = "saveMealInfo")
    public ResultBean saveMealInfo(@RequestParam(value = "token",required = true)String token,
                                   @RequestParam(value = "meal",required = true)String meal,
                                   @RequestParam(value = "type",required = true)String type){
        ResultBean resultBean = new ResultBean();

        String userId = getUserId(token);
        weChatUserService.saveMealInfo(resultBean,meal,type,userId);

        return resultBean;
    }


    @PostMapping(value = "saveLaxiInfo")
    public ResultBean saveLaxiInfo(@RequestParam(value = "token",required = true)String token,
                                   @RequestParam(value = "isLaxi",required = true)String isLaxi){
        ResultBean resultBean = new ResultBean();

        String userId = getUserId(token);


        return resultBean;
    }


    @GetMapping(value = "todayMealInfo")
    public ResultBean<MealDto> todayMealInfo(@RequestParam(value = "token",required = true)String token){
        ResultBean<MealDto> resultBean = new ResultBean();

        MealDto dto = weChatUserService.queryTodayMeal(getUserId(token));
        resultBean.setData(dto);

        return resultBean;
    }


    @PostMapping(value = "recordLaxi")
    public ResultBean recordLaxi(@RequestParam(value = "token",required = true)String token,
                                 @RequestParam(value = "laxiStatus",required = true)String laxiStatus){
        ResultBean resultBean = new ResultBean();

        weChatUserService.recordLaxiStatus(getUserId(token),laxiStatus);


        return resultBean;
    }
}

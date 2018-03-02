package com.lv.basui.service.impl;

import com.lv.basui.dao.WeChatUserDao;
import com.lv.basui.entity.WeChatInfo;
import com.lv.basui.service.TokenService;
import com.lv.basui.service.WeChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WeChatUserServiceImpl implements WeChatUserService {

    @Autowired
    private WeChatUserDao weChatUserDao;


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






}

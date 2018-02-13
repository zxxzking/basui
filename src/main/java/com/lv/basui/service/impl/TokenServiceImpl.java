package com.lv.basui.service.impl;

import com.lv.basui.service.TokenService;
import com.lv.basui.utils.ThreeDes;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    private Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);

    private final int LOSE_EFFICACY_DAY = 90;


    @Override
    public String createToken(Long userId) {
        String token = ThreeDes.encryptThreeDESECB(String.valueOf(userId) + "," + System.currentTimeMillis());
        return token;
    }

    @Override
    public boolean checkToken(String token) throws Exception {
        String s = ThreeDes.decryptThreeDESECB(token);
        if (StringUtils.isBlank(s)) {
            return false;
        }
        String[] split = s.split(",");
        if (split.length < 2) {
            // 解密结果错误 返回false
            return false;
        }

        String timeStamp = split[1];


        // 超过90天 token失效
        long res = System.currentTimeMillis() - Long.parseLong(timeStamp);

        int x = (int) (res / (3600 * 24 * 1000));
        if (x >= LOSE_EFFICACY_DAY) {
            return false;
        }


        return true;
    }


    public static void main(String[] args) throws Exception {
        String token = ThreeDes.encryptThreeDESECB(String.valueOf(180124102210000026l) + "," + System.currentTimeMillis());
        System.out.println(token);
       /* Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmSSS");
        String d = "201708131415111";
        Date parse = format.parse(d);
        System.out.println(date.getTime());
        System.out.println(parse.getTime());

        long res = date.getTime()-parse.getTime();
        System.out.println(res);
        System.out.println(res/(3600*24*1000));
        int x = (int)(res/(3600*24*1000));
        System.out.println(x);*/
        String s = ThreeDes.decryptThreeDESECB("tauEIDgZDj1xq31GUfl+LrSCWjsDQ5CDPyL0Q6gdGbOwo86XgmopjA==");
        String[] split = s.split(",");
        String userId = split[0];
        System.out.println(userId);
    }


}

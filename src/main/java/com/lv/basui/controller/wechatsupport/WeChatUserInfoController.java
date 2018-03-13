package com.lv.basui.controller.wechatsupport;

import com.lv.basui.dto.ResultBean;
import com.lv.basui.entity.WeChatInfo;
import com.lv.basui.service.WeChatUserService;
import com.lv.basui.utils.HttpToolKit;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping(value = "wechat")
public class WeChatUserInfoController {


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


}

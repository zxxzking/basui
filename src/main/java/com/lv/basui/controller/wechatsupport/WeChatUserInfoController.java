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

    /*@GetMapping(value = "a")
    public String test(){
        x++;


        System.out.println("a: "+x);
        return "Hello World  "+x+" a";
    }

    @GetMapping(value = "b")
    public String test1(){
        y++;
        System.out.println("b: "+y);
        return "Hello World  "+y+" b";
    }*/

    /*public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            exec.execute(new Runnable() {
                public void run() {

                    String res = HttpToolKit.doGet("http://192.168.65.138:8888/",null);
//                    String res = HttpUtils.get("http://192.168.65.223:9093/wechat/b");
                    System.out.println(res);

                }
            });
            exec.execute(new Runnable() {
                public void run() {
                    String res = HttpToolKit.doGet("http://192.168.65.138:8888/2",null);

//                    String res = HttpUtils.get("http://192.168.65.223:9093/wechat/a");
                    System.out.println(res);

                }
            });
        }
*//*
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*//*
        exec.shutdown();

    }*/
}

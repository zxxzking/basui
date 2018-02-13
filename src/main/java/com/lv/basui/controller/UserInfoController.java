package com.lv.basui.controller;

import com.lv.basui.dto.ResultBean;
import com.lv.basui.entity.User;
import com.lv.basui.service.TokenService;
import com.lv.basui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/needLogin")
public class UserInfoController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @GetMapping(value = "/userInfo")
    public ResultBean userInfo(@RequestParam(value = "token")String token){
        ResultBean resultBean = new ResultBean();
        User user = userService.getUser(Long.valueOf(getUserId(token)));
        resultBean.setData(user);
        return resultBean;
    }
}

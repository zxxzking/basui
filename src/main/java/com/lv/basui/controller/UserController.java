package com.lv.basui.controller;

import com.lv.basui.dto.CheckDto;
import com.lv.basui.dto.ResultBean;
import com.lv.basui.entity.User;
import com.lv.basui.service.TokenService;
import com.lv.basui.service.UserService;
import com.lv.basui.utils.JsonResponse;
import com.lv.basui.utils.SecurityUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/userInfo")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 校验用户名是否被占用
     * @return
     */

    @PostMapping(value = "/checkUserName")
    public ResultBean checkUserName(@RequestParam(value = "userName",required = true)String userName)throws Exception{
        ResultBean resultBean = new ResultBean();
        boolean b = userService.checkUserName(userName);
        resultBean.setData(b);
        return resultBean;
    }


    @PostMapping(value = "/register")
    public ResultBean register(@RequestParam(value = "username",required = true)String userName,
                               @RequestParam(value = "password",required = true)String passWord) throws Exception{
        ResultBean resultBean = new ResultBean();
        User user = new User();
        user.setName(userName);
        // 密码经过md5处理生成摘要
        passWord = SecurityUtils.string2MD5(passWord);
        user.setPassWord(passWord);
        userService.saveUser(user);
        User user1 = userService.getUser(userName);
        String token = tokenService.createToken(Long.valueOf(user.getId()));
        resultBean.setData(token);
        return resultBean;
    }

    @PostMapping(value = "/login")
    public ResultBean userLogin(@RequestParam(value = "username",required = true)String userName,
                                @RequestParam(value = "password",required = true)String passWord,
                            HttpServletRequest request,HttpServletResponse response)throws Exception{
        ResultBean resultBean = new ResultBean();
        Map map = new HashMap<String,Object>();
        CheckDto checkDto = userService.loginCheck(userName, passWord);
        User user = checkDto.getUser();
        String token = tokenService.createToken(Long.valueOf(user.getId()));
        resultBean.setData(token);
        return resultBean;
    }
}

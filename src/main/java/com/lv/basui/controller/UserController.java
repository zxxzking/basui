package com.lv.basui.controller;

import com.lv.basui.dto.CheckDto;
import com.lv.basui.entity.User;
import com.lv.basui.service.UserService;
import com.lv.basui.utils.JsonResponse;
import com.lv.basui.utils.SecurityUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller(value = "/userInfo")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 校验用户名是否被占用
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/checkUserName")
    @ResponseBody
    public String checkUserName(HttpServletRequest request, HttpServletResponse response){
        JsonResponse jsonResponse = null;
        Map map = new HashMap<String,Object>();
        String userName = request.getParameter("userName");
        if(StringUtils.isBlank(userName)){
            log.info("参数错误");
            jsonResponse = JsonResponse.buildSuccess("success",map);
            return jsonResponse.toJsonString();
        }else {
            // 返回true没被占用
            boolean b = userService.checkUserName(userName);
            map.put("flag", b);
            jsonResponse = JsonResponse.buildSuccess("success", map);
            return jsonResponse.toJsonString();
        }
    }



    @RequestMapping(value = "register")
    @ResponseBody
    public String register(HttpServletRequest request,HttpServletResponse response){
        JsonResponse jsonResponse = null;
        Map map = new HashMap<String,Object>();
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        if(StringUtils.isBlank(userName)||StringUtils.isBlank(passWord)){
            jsonResponse = JsonResponse.buildFailure("参数错误");
            return jsonResponse.toJsonString();
        }
        User user = new User();
        user.setName(userName);
        // 密码经过md5处理生成摘要
        passWord = SecurityUtils.string2MD5(passWord);
        user.setPassWord(passWord);
        boolean flag = true;
        try {
            flag = userService.saveUser(user);
        } catch (Exception e) {
            flag = false;
            log.error("注册失败");
        }
        map.put("flag",flag);
        request.getSession().setAttribute("user",user);
        jsonResponse = JsonResponse.buildSuccess("success",map);
        return jsonResponse.toJsonString();
    }

    @RequestMapping(value = "login")
    @ResponseBody
    public String userLogin(HttpServletRequest request,HttpServletResponse response){
        JsonResponse jsonResponse = null;
        Map map = new HashMap<String,Object>();
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        if(StringUtils.isBlank(userName)||StringUtils.isBlank(passWord)){
            jsonResponse = JsonResponse.buildFailure("参数错误");
            return jsonResponse.toJsonString();
        }
        CheckDto checkDto = userService.loginCheck(userName, passWord);
        if(!checkDto.getCode().equals("0000")){
            jsonResponse = JsonResponse.buildFailure(checkDto.getCode(),checkDto.getMsg());
            return jsonResponse.toJsonString();
        }
        return null;
    }
}

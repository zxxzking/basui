package com.lv.basui.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.lv.basui.dao.UserDao;
import com.lv.basui.dto.CheckDto;
import com.lv.basui.entity.User;
import com.lv.basui.service.UserService;
import com.lv.basui.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Autowired
    private DbHelper dbHelper;

    @Override
    public boolean checkUserName(String userName) {
        return userDao.checkUserName(userName);
    }

    @Override
    public boolean saveUser(User user){
        return dbHelper.insert(user);
    }


    @Override
    public CheckDto loginCheck(String userName,String password){
        CheckDto dto = new CheckDto();
        User user = userDao.queryUserByName(userName);
        if(null == user){
            dto.setCode("1001");
            dto.setMsg("用户不存在");
            return dto;
        }
        String newPassword = SecurityUtils.string2MD5(password);
        if(!newPassword.equals(user.getPassWord())){
            dto.setMsg("密码错误");
            dto.setCode("1002");
            return dto;
        }

        return dto;
    }

}

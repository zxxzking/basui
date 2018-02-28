package com.lv.basui.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.lv.basui.dao.UserDao;
import com.lv.basui.dto.CheckDto;
import com.lv.basui.entity.User;
import com.lv.basui.exception.BaseException;
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
    public boolean saveUser(User user) throws Exception{
        boolean b = checkUserName(user.getName());
        if(!b){
            throw new BaseException("1001","用户名已存在");
        }

        return userDao.saveUser(user);
    }


    @Override
    public CheckDto loginCheck(String userName,String password)throws Exception{
        CheckDto dto = new CheckDto();
        User user = userDao.queryUserByName(userName);
        if(null == user){
            throw new BaseException("1001","用户不存在");
        }
        String newPassword = SecurityUtils.string2MD5(password);
        if(!newPassword.equals(user.getPassWord())){
            throw new BaseException("1002","密码错误");
        }
        dto.setUser(user);
        return dto;
    }

    @Override
    public User getUser(String userName){
        String sql = "select * from user where name = ? and isactive = '1'";


        return dbHelper.queryForObject(sql,User.class,userName);
    }

    @Override
    public User getUser(Long userId){
        String sql = "select * from user where id = ? and isactive = '1'";


        return dbHelper.queryForObject(sql,User.class,userId);
    }

}

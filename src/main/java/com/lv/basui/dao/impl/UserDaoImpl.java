package com.lv.basui.dao.impl;

import com.lv.basui.dao.UserDao;
import com.lv.basui.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {



    @Override
    public boolean checkUserName(String userName){
        String sql = "select * from user where name=? and isactive = '1'";
        User user = dbHelper.queryForObject(sql, User.class, userName);
        if(null != user){
            return false;
        }else {
            return true;
        }
    }


    @Override
    public User queryUserByName(String userName){
        String sql = "select * from user where name=? and isactive = '1'";
        User user = dbHelper.queryForObject(sql, User.class, userName);
        return user;
    }
}

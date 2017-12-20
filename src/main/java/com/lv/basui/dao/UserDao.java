package com.lv.basui.dao;

import com.lv.basui.entity.User;

public interface UserDao {
    boolean checkUserName(String userName);

    User queryUserByName(String userName);
}

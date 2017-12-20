package com.lv.basui.service;


import com.lv.basui.dto.CheckDto;
import com.lv.basui.entity.User;

public interface UserService {
    /**
     * 查询用户名是否占用
     * @param userName
     * @return
     */
    boolean checkUserName(String userName);

    boolean saveUser(User user);

    CheckDto loginCheck(String userName, String password);
}

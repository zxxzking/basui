package com.lv.basui.dao;

import com.lv.basui.entity.WeChatInfo;

public interface WeChatUserDao {
    WeChatInfo isExist(String openId);

    Long saveUserInfo(WeChatInfo info);

    boolean updateUserInfo(WeChatInfo info);
}

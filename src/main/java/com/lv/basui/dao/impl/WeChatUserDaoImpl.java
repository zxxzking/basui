package com.lv.basui.dao.impl;

import com.lv.basui.dao.WeChatUserDao;
import com.lv.basui.entity.WeChatInfo;
import org.springframework.stereotype.Repository;

@Repository
public class WeChatUserDaoImpl extends BaseDao implements WeChatUserDao {

    @Override
    public WeChatInfo isExist(String openId){
        String sql = "select * from weChat_info where openId = ?";
        return dbHelper.queryForObject(sql, WeChatInfo.class,openId);
    }

    @Override
    public Long saveUserInfo(WeChatInfo info){
        Long id = generatorKey("weChat_info");
        info.setId(id);
        dbHelper.insert(info);

        return id;
    }

}

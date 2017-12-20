package com.lv.basui.dto;

import com.lv.basui.entity.User;

public class CheckDto {

    // 默认0000校验通过
    private String code="0000";

    private String msg;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

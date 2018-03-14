package com.lv.basui.dto;

import com.lv.basui.utils.GsonUtils;

public class SocketResp {

    private int onlineNum;

    public int getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(int onlineNum) {
        this.onlineNum = onlineNum;
    }

    public String toJsonString() {
        return GsonUtils.getJson(this, "yyyy-MM-dd HH:mm:ss");
    }

}

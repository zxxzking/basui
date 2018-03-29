package com.lv.basui.dto;

import com.lv.basui.utils.GsonUtils;

public class SocketResp<T> {

    private int onlineNum;

    private String msgType;

    private String target;


    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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

package com.lv.basui.dto;

public class CheckDto {

    // 默认0000校验通过
    private String code="0000";

    private String msg;

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

package com.lv.basui.dto;


import javax.validation.constraints.NotNull;

public class WeatherReqDto {

    @NotNull(message = "not null")
    private String city;
    private String appkey;



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }
}

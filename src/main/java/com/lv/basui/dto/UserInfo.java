package com.lv.basui.dto;

public class UserInfo {

    // 昵称
    private String nickName;

    // 头像地址
    private String avatarUrl;

    // 纬度
    private Double latitude;

    // 经度
    private Double longitude;

    // 附近的人数
    private int nearbyNum;


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getNearbyNum() {
        return nearbyNum;
    }

    public void setNearbyNum(int nearbyNum) {
        this.nearbyNum = nearbyNum;
    }
}

package com.lv.basui.dto;

import java.io.Serializable;

public class UserInfo extends SocketReceiveMsg implements Serializable {

    // 附近的人数
    private int nearbyNum;


    public int getNearbyNum() {
        return nearbyNum;
    }

    public void setNearbyNum(int nearbyNum) {
        this.nearbyNum = nearbyNum;
    }
}

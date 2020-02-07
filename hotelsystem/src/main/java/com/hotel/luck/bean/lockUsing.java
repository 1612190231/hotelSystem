package com.hotel.luck.bean;

import java.util.Date;

public class lockUsing {
    private Integer lockusingId;

    private Integer hotelId;

    private Integer userId;

    private String userName;

    private Date time;

    public Integer getLockusingId() {
        return lockusingId;
    }

    public void setLockusingId(Integer lockusingId) {
        this.lockusingId = lockusingId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
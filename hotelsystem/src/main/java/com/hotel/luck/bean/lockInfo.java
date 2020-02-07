package com.hotel.luck.bean;

public class lockInfo {
    private Integer lockId;

    private Integer hotelId;

    private Double longitude;

    private Double latitude;

    private String address;

    private Integer lockStatus;

    public Integer getLockId() {
        return lockId;
    }

    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }
}
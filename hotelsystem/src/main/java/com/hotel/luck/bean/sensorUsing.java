package com.hotel.luck.bean;

public class sensorUsing {
    private Integer sensorusingId;

    private Integer hotelId;

    private String temp;

    private String humidity;

    private String fire;

    private String shine;

    private String tvoc;

    private String co2;

    private String point;

    private Double longitude;

    private Double latitude;

    public Integer getSensorusingId() {
        return sensorusingId;
    }

    public void setSensorusingId(Integer sensorusingId) {
        this.sensorusingId = sensorusingId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }

    public String getFire() {
        return fire;
    }

    public void setFire(String fire) {
        this.fire = fire == null ? null : fire.trim();
    }

    public String getShine() {
        return shine;
    }

    public void setShine(String shine) {
        this.shine = shine == null ? null : shine.trim();
    }

    public String getTvoc() {
        return tvoc;
    }

    public void setTvoc(String tvoc) {
        this.tvoc = tvoc == null ? null : tvoc.trim();
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2 == null ? null : co2.trim();
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
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
}
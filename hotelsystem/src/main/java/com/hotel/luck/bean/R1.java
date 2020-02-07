package com.hotel.luck.bean;

public class R1 {
    private Integer r1id;

    private String url;

    public Integer getR1id() {
        return r1id;
    }

    public void setR1id(Integer r1id) {
        this.r1id = r1id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}
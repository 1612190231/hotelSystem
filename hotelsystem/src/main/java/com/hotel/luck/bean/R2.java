package com.hotel.luck.bean;

public class R2 {
    private Integer r2id;

    private String url;

    public Integer getR2id() {
        return r2id;
    }

    public void setR2id(Integer r2id) {
        this.r2id = r2id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}
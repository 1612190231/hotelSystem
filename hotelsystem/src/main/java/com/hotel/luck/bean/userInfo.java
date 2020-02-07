package com.hotel.luck.bean;

import java.util.Date;

public class userInfo {
    private Integer userId;

    private String userName;

    private String password;

    private Date bathday;

    private String telephone;

    private String trueName;

    private String idCard;

    private String cardUrl;

    private String sex;

    private Integer age;

    private Date registerTime;

    private Integer isValidate;

    private String likeList;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getBathday() {
        return bathday;
    }

    public void setBathday(Date bathday) {
        this.bathday = bathday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl == null ? null : cardUrl.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(Integer isValidate) {
        this.isValidate = isValidate;
    }

    public String getLikeList() {
        return likeList;
    }

    public void setLikeList(String likeList) {
        this.likeList = likeList == null ? null : likeList.trim();
    }
}
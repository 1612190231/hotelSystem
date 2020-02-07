package com.hotel.luck.utils;

public class Message {

    private int code;

    private String msg;

    private Object data;

    public static Message createSuc(Object o) {

        return new Message(200, null, o);
    }

    public static Message createErr(String msg) {
        return new Message(500, msg, null);
    }

    public Message(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {

        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}

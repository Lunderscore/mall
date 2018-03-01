package com.ou.mall.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    /**
     * 0: success, 1: failure;
     */
    private int code;
    private String message;
    private Map<String, Object> content;

    public Msg add(String key, Object value) {
        this.getContent().put(key, value);

        return this;
    }

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(0);
        msg.content = new HashMap<>();
        return msg;
    }

    public static Msg failure(String message) {
        Msg msg = new Msg();
        msg.setCode(1);
        msg.setMessage(message);
        msg.content = new HashMap<>();
        return msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }
}

package com.ou.mall.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    /**
     * 0: success, 1: failure;
     */
    private int code;

    private Map<String, Object> content = new HashMap<String, Object>();

    public Msg add(String key, Object value) {
        this.getContent().put(key, value);

        return this;
    }

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(0);

        return msg;
    }

    public static Msg failure() {

        Msg msg = new Msg();
        msg.setCode(1);

        return msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

}

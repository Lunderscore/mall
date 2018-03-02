package com.ou.mall.bean;

import java.math.BigDecimal;

public class userInfo {
    private Integer ufid;

    private Integer uid;

    private BigDecimal money;

    private String avatar;

    public Integer getUfid() {
        return ufid;
    }

    public void setUfid(Integer ufid) {
        this.ufid = ufid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ufid=").append(ufid);
        sb.append(", uid=").append(uid);
        sb.append(", money=").append(money);
        sb.append(", avatar=").append(avatar);
        sb.append("]");
        return sb.toString();
    }
}
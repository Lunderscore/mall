package com.ou.mall.bean;

import com.ou.mall.validtion.RechargeValidtion;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

public class UserInfo {
    @Null(groups = RechargeValidtion.class)
    private Integer ufid;

    @Null(groups = RechargeValidtion.class)
    private Integer uid;

    @NotNull(message = "价格不能为空", groups = RechargeValidtion.class)
    @DecimalMin(value = "0.01", message = "价格最低0.01", groups = RechargeValidtion.class)
    private BigDecimal money;

    @Null(groups = RechargeValidtion.class)
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
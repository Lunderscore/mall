package com.ou.mall.bean;

import com.ou.mall.validation.UserLogin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

public class User {
    @Null(groups = UserLogin.class)
    private Integer uid;

    @NotNull(groups = UserLogin.class)
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$",
            message = "账号格式：字母开头，允许5-16字节，允许字母数字下划线",
            groups = UserLogin.class)
    private String username;

    @NotNull(groups = UserLogin.class)
    @Pattern(regexp = "^[a-zA-Z]\\w{5,17}$",
            message = "密码格式：字母开头，长度在6~18之间，只能包含字母、数字和下划线",
            groups = UserLogin.class)
    private String password;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }
}
package com.ou.mall.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
    private Integer userId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$")
    private String userUsername;

    @NotNull
    @Pattern(regexp="^[a-zA-Z]\\w{5,17}$")
    private String userPassword;

    private String userAvatar;

    private Double userMoney;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername == null ? null : userUsername.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Double userMoney) {
        this.userMoney = userMoney;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", userAvatar=" + userAvatar + ", userMoney=" + userMoney + "]";
	}
    
    
}
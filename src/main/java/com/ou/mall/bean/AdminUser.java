package com.ou.mall.bean;

public class AdminUser {
    private Integer userId;

    private String userrUsername;

    private String userPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserrUsername() {
        return userrUsername;
    }

    public void setUserrUsername(String userrUsername) {
        this.userrUsername = userrUsername == null ? null : userrUsername.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
}
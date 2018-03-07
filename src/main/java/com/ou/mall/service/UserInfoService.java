package com.ou.mall.service;

import com.ou.mall.bean.UserInfo;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 22:17
 */
public interface UserInfoService {
    /**
     * 根据用户id获取userInfo 如果没有用户信息则初始化用户信息
     *
     * @param uid
     * @return userInfo
     */
    UserInfo getUserInfo(Integer uid);

    /**
     * @param userInfo 需要更新的用户信息
     * @param uid 用户主键
     */
    void UpdateUserInfo(UserInfo userInfo, Integer uid);
}
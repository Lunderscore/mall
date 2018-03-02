package com.ou.mall.service;

import com.ou.mall.bean.UserInfo;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 22:17
 */
public interface UserInfoService {
    /**
     * 根据用户id获取userInfo
     *
     * @param uid
     * @return userInfo
     */
    UserInfo getUserInfo(Integer uid);

    /**
     * 新建用户信息
     *
     * @param uid
     * @return userInfo
     */
    UserInfo createUserinfo(Integer uid);
}
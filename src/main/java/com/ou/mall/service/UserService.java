package com.ou.mall.service;

import com.ou.mall.bean.User;

public interface UserService {
    /**
     * @param user 根据username password 查询出User
     * @return null 或 user
     */
    User login(User user);

    /**
     * @param user 需要注册的用户信息
     * @return true:注册成功 false:注册失败
     */
    boolean register(User user);

    /**
     * @param id
     * @return user
     */
    User getUser(Integer id);
}

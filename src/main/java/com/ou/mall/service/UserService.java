package com.ou.mall.service;

import com.ou.mall.bean.User;
import com.ou.mall.exception.HasUsernameException;

/**
 * @author: kpkym
 * date: 2018/3/1
 * time: 22:17
 */
public interface UserService {
    /**
     * @param user 根据username password 查询出User
     * @return null 或 user
     */
    User login(User user);

    /**
     * @param user 需要注册的用户信息
     * @return true:注册成功 false:注册失败
     * @throws HasUsernameException 存在当前用户名
     */
    boolean register(User user) throws HasUsernameException;

    /**
     * @param id
     * @return user
     */
    User getUser(Integer id);

    /**
     * @param username
     * @return null or user
     */
    User getUser(String username);

}

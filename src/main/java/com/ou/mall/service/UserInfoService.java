package com.ou.mall.service;

import com.ou.mall.bean.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
     * @param userInfo 充值
     * @param uid 用户主键
     */
    void recharge(UserInfo userInfo, Integer uid);

    /**
     * @param realPath 项目绝对路径
     * @param image 保存的图片
     * @param uid 用户id
     * @throws IOException
     */
    void insertAvatar(String realPath, MultipartFile image, Integer uid) throws IOException;
}
package com.ou.mall.service;

import com.ou.mall.bean.UserAddress;

import java.util.List;

/**
 * @author: kpkym
 * date: 2018/3/12
 * time: 12:34
 */
public interface UserAddressService {
    /**
     * 获取用户收货信息列表
     *
     * @param uid 用户uid
     * @return 收货信息列表
     */
    List<UserAddress> listUserAddress(Integer uid);

    /**
     * @param uaid 收货信息id
     * @return
     */
    UserAddress getUserAddress(Integer uaid);


    /**
     * @param uid 用户id
     * @param userAddress
     */
    void insertUserAddress(Integer uid, UserAddress userAddress);

    /**
     * @param userAddress
     * @param uaid
     * @return
     */
    void updateUserAddress(UserAddress userAddress, Integer uaid);


}

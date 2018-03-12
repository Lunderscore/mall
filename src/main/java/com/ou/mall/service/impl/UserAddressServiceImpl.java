package com.ou.mall.service.impl;

import com.ou.mall.bean.UserAddress;
import com.ou.mall.bean.UserAddressExample;
import com.ou.mall.dao.UserAddressMapper;
import com.ou.mall.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: kpkym
 * date: 2018/3/12
 * time: 12:35
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> listUserAddress(Integer uid) {
        UserAddressExample example = new UserAddressExample();
        example.createCriteria().andUidEqualTo(uid);
        return userAddressMapper.selectByExample(example);
    }

    @Override
    public UserAddress getUserAddress(Integer uaid) {
        return userAddressMapper.selectByPrimaryKey(uaid);
    }

    @Override
    public void insertUserAddress(Integer uid, UserAddress userAddress) {
        userAddress.setUid(uid);
        userAddressMapper.insertSelective(userAddress);
    }

    @Override
    public void updateUserAddress(UserAddress userAddress, Integer uaid) {
        userAddress.setId(uaid);
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }
}
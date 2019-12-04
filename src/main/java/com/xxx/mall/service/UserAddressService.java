package com.xxx.mall.service;

import com.xxx.mall.bean.po.UserAddress;
import com.xxx.mall.bean.po.UserAddressExample;
import com.xxx.mall.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressService {

    @Autowired
    UserAddressMapper userAddressMapper;

    public void updateAddress(UserAddress address, Integer userID) {
        if (hasUserAddressByUserID(userID)) {

            UserAddressExample example = new UserAddressExample();
            UserAddressExample.Criteria createCriteria = example.createCriteria();
            createCriteria.andAddressUidEqualTo(userID);

            userAddressMapper.updateByExampleSelective(address, example);
            return;
        }

        addAddress(address, userID);
    }

    public boolean hasUserAddressByUserID(Integer userID) {

        UserAddressExample example = new UserAddressExample();
        UserAddressExample.Criteria createCriteria = example.createCriteria();
        createCriteria.andAddressUidEqualTo(userID);
        List<UserAddress> selectByExample = userAddressMapper.selectByExample(example);

        return !selectByExample.isEmpty();
    }

    public void addAddress(UserAddress address, Integer userID) {
        address.setAddressUid(userID);
        userAddressMapper.insert(address);
    }

    public UserAddress selectUserAddressByUid(Integer uid) {
        UserAddressExample example = new UserAddressExample();
        example.createCriteria().andAddressUidEqualTo(uid);
        List<UserAddress> selectByExample = userAddressMapper.selectByExample(example);

        return selectByExample.isEmpty() ? new UserAddress() : selectByExample.get(0);
    }
}

package com.ou.mall.service.impl;

import com.ou.mall.bean.UserInfo;
import com.ou.mall.bean.UserInfoExample;
import com.ou.mall.dao.UserInfoMapper;
import com.ou.mall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 22:22
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(Integer uid) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        // 如果没有用户信息 新建用户信息
        if (userInfos.size() == 0) {
            return createUserInfo(uid);
        }
        return userInfos.get(0);
    }

    @Override
    public void UpdateUserInfo(UserInfo userInfo, Integer uid) {
        userInfo.setUid(uid);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    private UserInfo createUserInfo(Integer uid) {
        UserInfo userinfo = new UserInfo();
        userinfo.setMoney(new BigDecimal("0.00"));
        userinfo.setUid(uid);
        userInfoMapper.insertSelective(userinfo);
        return userinfo;
    }
}
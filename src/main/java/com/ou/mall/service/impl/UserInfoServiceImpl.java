package com.ou.mall.service.impl;

import com.ou.mall.bean.UserInfo;
import com.ou.mall.bean.UserInfoExample;
import com.ou.mall.dao.UserInfoMapper;
import com.ou.mall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 22:22
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Value("${userInfo.avatar.dir}")
    String avatarDir;

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
    public void recharge(UserInfo userInfo, Integer uid) {
        UserInfo oldUserInfo = getUserInfo(uid);
        oldUserInfo.setMoney(oldUserInfo.getMoney().add(userInfo.getMoney()));
        userInfoMapper.updateByPrimaryKeySelective(oldUserInfo);
    }

    @Override
    public void insertAvatar(String realPath, MultipartFile image, Integer uid) throws IOException {
        String suffix = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
        String filename = UUID.randomUUID().toString() + suffix;
        String location = realPath + avatarDir;
        if (!new File(location).exists()) {
            new File(location).mkdirs();
        }
        File file = new File(location, filename);
        UserInfo userInfo = getUserInfo(uid);
        userInfo.setAvatar(file.getAbsolutePath());
        userInfoMapper.updateByPrimaryKey(userInfo);
        image.transferTo(file);
    }

    private UserInfo createUserInfo(Integer uid) {
        UserInfo userinfo = new UserInfo();
        userinfo.setMoney(new BigDecimal("0.00"));
        userinfo.setUid(uid);
        userInfoMapper.insertSelective(userinfo);
        return userinfo;
    }
}
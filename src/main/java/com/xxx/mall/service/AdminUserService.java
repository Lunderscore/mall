package com.xxx.mall.service;


import com.xxx.mall.bean.po.AdminUser;
import com.xxx.mall.bean.po.AdminUserExample;
import com.xxx.mall.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {

    @Autowired
    AdminUserMapper adminUserMapper;

    public AdminUser login(AdminUserExample example) {
        List<AdminUser> selectByExample = adminUserMapper.selectByExample(example);
        return selectByExample.isEmpty() ? null : selectByExample.get(0);
    }
}

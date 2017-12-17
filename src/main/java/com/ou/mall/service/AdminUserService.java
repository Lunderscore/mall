package com.ou.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.AdminUser;
import com.ou.mall.bean.AdminUserExample;
import com.ou.mall.dao.AdminUserMapper;

@Service
public class AdminUserService {

	@Autowired
	AdminUserMapper adminUserMapper;
	
	public AdminUser login(AdminUserExample example){
		List<AdminUser> selectByExample = adminUserMapper.selectByExample(example);
		return selectByExample.isEmpty() ? null : selectByExample.get(0);
	}
}

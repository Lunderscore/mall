package com.ou.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.User;
import com.ou.mall.bean.UserAvatar;
import com.ou.mall.bean.UserAvatarExample;
import com.ou.mall.bean.UserExample;
import com.ou.mall.bean.UserExample.Criteria;
import com.ou.mall.dao.UserAvatarMapper;
import com.ou.mall.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserAvatarMapper userAvatarMapper;

	public boolean register(User user){
		
		if (getUserByUsername(user.getUserUsername()) != null){
			return false;
		}
		
		user.setUserMoney(0);
		return userMapper.insert(user) != 0;
	}
	
	public boolean login(User user){
		
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserUsernameEqualTo(user.getUserUsername());
		createCriteria.andUserPasswordEqualTo(user.getUserPassword());
		
		return !userMapper.selectByExample(example).isEmpty();
	}
	
	public User getUserByUsername(String username){
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserUsernameEqualTo(username);
		
		List<User> selectByExample = userMapper.selectByExample(example);
		
		return selectByExample.isEmpty() ? null : selectByExample.get(0);
	}


	public void update(User record) {
		userMapper.updateByPrimaryKeySelective(record);
	}

	public void uploadAvatar(Integer userID, String path) {
		UserAvatar avatar = new UserAvatar();
		avatar.setAvatarUri(path);

		if (hasAvatar(userID)){
			UserAvatarExample example = new UserAvatarExample();
			example.createCriteria().andAvatarUidEqualTo(userID);
			userAvatarMapper.updateByExampleSelective(avatar, example);
			return;
		}
		avatar.setAvatarUid(userID);
		userAvatarMapper.insert(avatar);
		return;
		
	}
	public boolean hasAvatar(Integer userID){
		UserAvatarExample example = new UserAvatarExample();
		example.createCriteria().andAvatarUidEqualTo(userID);
		
		return !userAvatarMapper.selectByExample(example).isEmpty();
	}

	public void payment() {
		
	}
	
}

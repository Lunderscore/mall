package com.ou.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.User;
import com.ou.mall.bean.UserExample;
import com.ou.mall.bean.UserExample.Criteria;
import com.ou.mall.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public User getUserByUsernameAndPassWord(User user){
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserUsernameEqualTo(user.getUserUsername());
		createCriteria.andUserPasswordEqualTo(user.getUserPassword());
		
		List<User> selectByExample = userMapper.selectByExample(example);
		return selectByExample.isEmpty() ? null : selectByExample.get(0);
	}

	public void insert(User user){
		userMapper.insert(user);
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

//	public void uploadAvatar(Integer userID, String path) {
//		UserAvatar avatar = new UserAvatar();
//		avatar.setAvatarUri(path);
//
//		if (hasAvatar(userID)){
//			UserAvatarExample example = new UserAvatarExample();
//			example.createCriteria().andAvatarUidEqualTo(userID);
//			userAvatarMapper.updateByExampleSelective(avatar, example);
//			return;
//		}
//		avatar.setAvatarUid(userID);
//		userAvatarMapper.insert(avatar);
//		return;
		

	public boolean addMoney(int money, Integer uid) {
		User record = userMapper.selectByPrimaryKey(uid);
		Integer newMoney = record.getUserMoney() + money;
		if (newMoney < 0){
			return false;
		}
		
		record.setUserMoney(newMoney);
		userMapper.updateByPrimaryKeySelective(record);
		return true;
	}
	
}

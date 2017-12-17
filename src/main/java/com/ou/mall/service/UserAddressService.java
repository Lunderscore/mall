package com.ou.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.UserAddress;
import com.ou.mall.bean.UserAddressExample;
import com.ou.mall.bean.UserAddressExample.Criteria;
import com.ou.mall.dao.UserAddressMapper;

@Service
public class UserAddressService {

	@Autowired
	UserAddressMapper userAddressMapper;
	
	public void updateAddress(UserAddress address, Integer userID) {
		if (hasUserAddressByUserID(userID)){
			
			UserAddressExample example = new UserAddressExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andAddressUidEqualTo(userID);
			
			userAddressMapper.updateByExampleSelective(address, example);
			return;
		}
		
		addAddress(address, userID);
	}
	
	public boolean hasUserAddressByUserID(Integer userID){
		
		UserAddressExample example = new UserAddressExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andAddressUidEqualTo(userID);
		List<UserAddress> selectByExample = userAddressMapper.selectByExample(example);
		
		return !selectByExample.isEmpty();
	}
	
	public void addAddress(UserAddress address, Integer userID){
		address.setAddressUid(userID);
		userAddressMapper.insert(address);
	}
	
	public UserAddress selectUserAddressByUid(Integer uid){
		UserAddressExample example = new UserAddressExample();
		example.createCriteria().andAddressUidEqualTo(uid);
		List<UserAddress> selectByExample = userAddressMapper.selectByExample(example);
		
		return selectByExample.isEmpty() ? new UserAddress() : selectByExample.get(0);
	}
}

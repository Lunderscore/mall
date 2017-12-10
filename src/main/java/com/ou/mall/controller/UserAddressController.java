package com.ou.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.UserAddress;
import com.ou.mall.service.UserAddressService;

@Controller
public class UserAddressController {
	@Autowired
	UserAddressService userAddressService;
	
	@ResponseBody
	@RequestMapping(value="userAddress", method=RequestMethod.PUT)
	public Msg updateAddress(UserAddress address, HttpSession session){
		Integer userID = (Integer) session.getAttribute("user");
		
		userAddressService.updateAddress(address, userID);
		
		
		return Msg.success();
	}
}

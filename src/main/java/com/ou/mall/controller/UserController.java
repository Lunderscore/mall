package com.ou.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.User;

@Controller
public class UserController {

	@ResponseBody
	@RequestMapping(value="user", method=RequestMethod.GET)
	public Msg login(User user){
		
		String username = user.getUsername();
		String password = user.getPassword();
		System.out.println("GET");

		if (username.equals("1") && password.equals("1")){
			return Msg.success();
		}

		return Msg.failure();
	}
	
	@ResponseBody
	@RequestMapping(value="user", method=RequestMethod.POST)
	public Msg register(User user){
		
		String username = user.getUsername();
		String password = user.getPassword();
		System.out.println("POST");

		if (username.equals("1") && password.equals("1")){
			return Msg.success();
		}
		return Msg.failure();
	}
}

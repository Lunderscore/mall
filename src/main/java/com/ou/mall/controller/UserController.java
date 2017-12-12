package com.ou.mall.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.UploadedImageFile;
import com.ou.mall.bean.User;
import com.ou.mall.service.UserService;
import com.ou.mall.util.ImageUtil;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@ResponseBody
	@RequestMapping(value="user", method=RequestMethod.GET)
	public Msg login(User user, HttpSession session){
		
		if (userService.login(user)){
			user = userService.getUserByUsername(user.getUserUsername());
			session.setAttribute("user", user.getUserId());
			return Msg.success();
		}
		
		return Msg.failure();
	}
	
	@ResponseBody
	@RequestMapping(value="user", method=RequestMethod.POST)
	public Msg register(User user){
		if (userService.register(user)){
			return Msg.success();
		}
		
		return Msg.failure();
	}
	
	@ResponseBody
	@RequestMapping(value="user", method=RequestMethod.PUT)
	public Msg update(User user, HttpSession session){
		
		Integer userId = (Integer) session.getAttribute("user");
		user.setUserId(userId);
		
		userService.update(user);
		return Msg.failure();
	}
	
	@ResponseBody
	@RequestMapping(value="avatar")
	public Msg uploadavatar(UploadedImageFile image, HttpSession session) throws IllegalStateException, IOException{
		
		Integer userID = (Integer) session.getAttribute("user");
		String id = userID.toString();
		String avatarPath = session.getServletContext().getRealPath("/data/img/userAvatar/");
        String newImageName = ImageUtil.transfer(image, avatarPath, id);
        
        if (newImageName == null){
        	return Msg.failure();
        }
        userService.uploadAvatar(userID, "data/img/userAvatar/"+newImageName);
        return Msg.success();
	}

	@ResponseBody
	@RequestMapping(value="userPayment")
	public Msg payment(HttpSession session,@RequestParam("mid") String payMoney){
		Integer uid = (Integer) session.getAttribute("user");
		
		userService.payment(uid, Integer.parseInt(payMoney));
		return Msg.success();
	}
	
	
	@ResponseBody
	@RequestMapping(value="logOut")
	public Msg logOut(HttpSession session){
		System.out.println("logOut");
		session.removeAttribute("user");
		return Msg.success();
	}
	
	
	
}

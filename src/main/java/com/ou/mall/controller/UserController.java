package com.ou.mall.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.UploadedImageFile;
import com.ou.mall.bean.User;
import com.ou.mall.service.UserService;

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
		String name = userID.toString();
		String originalFilename = image.getImage().getOriginalFilename();
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		
//		后缀名判断
		String[] allowSuffix= {".jpg", ".png", ".gif", ".jpeg", ".bmp"};
		for (int i=0; i<allowSuffix.length; i++){
			if ( suffix.equals(allowSuffix[i])){
				break;
			}else if (i == allowSuffix.length-1){
				return Msg.failure(); 
			}
		}
		
		String avatarPath = session.getServletContext().getRealPath("/data/img/userAvatar/");
        String newImageName = name + suffix;
        File newFile = new File(avatarPath, newImageName);
        newFile.getParentFile().mkdirs();
        image.getImage().transferTo(newFile);
		
        userService.uploadAvatar(userID, "data/img/userAvatar/"+newImageName);
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

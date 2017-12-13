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

	@Autowired
	HttpSession session;
	
	
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
//        userService.uploadAvatar(userID, "data/img/userAvatar/"+newImageName);
        return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="money")
	public Msg payment(@RequestParam(value="mid", defaultValue="0") Integer payMoney, @RequestParam(value="type", defaultValue="0") Integer type){
		User user = (User) session.getAttribute("userSession");
		if (payMoney==null || "".equals(payMoney)){
			return Msg.failure().add("msg", "操作错误");
		}else if(user==null){
			return Msg.failure().add("msg", "你还没有登录");
		}else if (type == 1){
			payMoney = -payMoney;
		}
		
		Integer uid = user.getUserId();
		userService.addMoney(payMoney, uid);
		return Msg.success();
	}
}

package com.ou.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.UserOrder;
import com.ou.mall.service.UserOrderService;

@Controller
public class UserOrderController {
	@Autowired
	UserOrderService userOrderService;
	
	@ResponseBody
	@RequestMapping("order")
	public Msg createOrder(HttpSession session, @RequestParam("pid") Integer pid, @RequestParam("num") Integer num){
		Integer uid = (Integer) session.getAttribute("user");
		if (num==null || "".equals(num)){
			return Msg.failure();
		}
		
		userOrderService.createOrder(uid, pid, num);
		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping("delOrder")
	public Msg deleteOrder(@RequestParam("uoid")Integer uoid){

		userOrderService.deleteOrder(uoid);
		return Msg.success();
	}
	
	
	@ResponseBody
	@RequestMapping("shoppingCar")
	public Msg getShoppingCar(HttpSession session){
		Integer uid = (Integer) session.getAttribute("user");
		if (uid == null){
			return Msg.failure();
		}
		
		List<UserOrder> shoppingCar = userOrderService.getShoppingCar(uid);
		session.setAttribute("shoppingCar", shoppingCar);
		
		return Msg.success().add("shoppingCar", shoppingCar);
	}
	

}

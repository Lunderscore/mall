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
	
	@ResponseBody
	@RequestMapping("confirmOrder")
	public Msg confirmOrder(HttpSession session){
		Integer uid = (Integer) session.getAttribute("user");
		if (uid == null){
			return Msg.failure();
		}
		
		List<UserOrder> shoppingCar = userOrderService.getShoppingCar(uid);
		session.setAttribute("shoppingCar", shoppingCar);
		
		return Msg.success().add("shoppingCar", shoppingCar);
	}

	@ResponseBody
	@RequestMapping("totalOrder")
	public Msg totalOrder(HttpSession session){
		Integer uid = (Integer) session.getAttribute("user");
		List<UserOrder> totalOrder = userOrderService.totalOrder(uid);
		session.setAttribute("userOrder", totalOrder);
		return Msg.success().add("userOrder", totalOrder);
	}
	@ResponseBody
	@RequestMapping("waitPay")
	public Msg waitPay(HttpSession session){
		Integer uid = (Integer) session.getAttribute("user");
		List<UserOrder> waitPay = userOrderService.waitPay(uid);
		session.setAttribute("userOrder", waitPay);

		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping("waitDeliver")
	public Msg waitDeliver(HttpSession session){
		Integer uid = (Integer) session.getAttribute("user");
		List<UserOrder> waitDeliver = userOrderService.waitDeliver(uid);
		session.setAttribute("userOrder", waitDeliver);

		return Msg.success().add("userOrder", waitDeliver);
	}
	
	@ResponseBody
	@RequestMapping("waitConfirm")
	public Msg waitConfirm(HttpSession session){
		Integer uid = (Integer) session.getAttribute("user");
		List<UserOrder> waitConfirm = userOrderService.waitConfirm(uid);
		session.setAttribute("userOrder", waitConfirm);

		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping("waitComment")
	public Msg waitComment(HttpSession session){
		Integer uid = (Integer) session.getAttribute("user");
		List<UserOrder> waitComment = userOrderService.waitComment(uid);
		session.setAttribute("userOrder", waitComment);

		return Msg.success();
	}
	
}

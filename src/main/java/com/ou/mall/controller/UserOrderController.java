package com.ou.mall.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
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
		if (num==null || "".equals(num) || uid==null){
			return Msg.failure();
		}
		
		userOrderService.createOrder(uid, pid, num);
		return Msg.success();
	}
	
	@RequestMapping("shoppingCarConfirm")
	public String shoppingCarConfirm(@RequestParam("uoid") Integer uoid, @RequestParam("totalMoney") Integer totalMoney, 
			UserOrder userOrder, HttpServletRequest request){
		
		userOrder.setOrderId(uoid);
		Date orderDateTime = new Date(System.currentTimeMillis());
		userOrder.setOrderDateTime(orderDateTime);
		userOrderService.updateOrderByPrimaryKey(userOrder);
		request.setAttribute("totalMoney", totalMoney);
		
		return "paymentMapping";
	}
	
	@ResponseBody
	@RequestMapping("delOrder")
	public Msg deleteOrder(@RequestParam("uoid")Integer uoid){

		userOrderService.deleteOrder(uoid);
		return Msg.success();
	}
	
	
	@RequestMapping("shoppingCar")
	public String getShoppingCar(HttpSession session){
		Integer uid = (Integer) session.getAttribute("user");
		if (uid == null){
			return "loginMapping";
		}
		
		List<UserOrder> shoppingCar = userOrderService.getShoppingCar(uid);
		session.setAttribute("shoppingCar", shoppingCar);
		
		return "shoppingCarMapping";
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

	@RequestMapping("userOrder")
	public String userOrderPage(HttpSession session, @RequestParam(value="type", defaultValue="0") String type){
		Integer uid = (Integer) session.getAttribute("user");
		if (uid == null){
			return "loginMapping";
		}
		
		List<UserOrder> totalOrder = userOrderService.userOrderPage(uid, Integer.parseInt(type));
		session.setAttribute("userOrder", totalOrder);
		return "userOrderMapping";
	}
}

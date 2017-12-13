package com.ou.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.User;
import com.ou.mall.bean.UserOrder;
import com.ou.mall.service.UserOrderService;

@Controller
public class UserOrderController {
	@Autowired
	UserOrderService userOrderService;
	
	@ResponseBody
	@RequestMapping("/order")
	public Msg createOrder(HttpSession session, @RequestParam("pid") Integer pid, @RequestParam("num") Integer num){
		User user = (User) session.getAttribute("userSession");
		if (num==null || "".equals(num)){
			return Msg.failure().add("msg", "数量输入错误");
		}else if(user==null){
			return Msg.failure().add("msg", "你还没有登录");
		}
		
		Integer uid = user.getUserId();
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
	@RequestMapping("delOrderBatch")
	public Msg delOrderBatch(@RequestParam("uoid")String uoid){
		if (uoid==null || "".equals(uoid)){
			return Msg.failure();
		}
		
		String[] uoids = uoid.split("-");
		for (String id : uoids){
			userOrderService.deleteOrder(Integer.parseInt(id));
		}
		
		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping("confirmOrder")
	public Msg confirmOrder(HttpSession session){
		Integer uid = (Integer) session.getAttribute("user");
		if (uid == null){
			return Msg.failure();
		}
		
//		List<UserOrder> shoppingCar = userOrderService.getShoppingCar(uid);
//		session.setAttribute("shoppingCar", shoppingCar);
		
		return Msg.success();
	}

	@ResponseBody
	@RequestMapping("updateOrder")
	public Msg updateOrder(HttpSession session, @RequestParam("uoid") String uoid
			, @RequestParam("type") Integer type){

		String[] uoids = uoid.split("-");
		for (String id : uoids){
			UserOrder uo = new UserOrder();
			uo.setOrderId(Integer.parseInt(id));
			uo.setOrderStatus(type);
			userOrderService.updateByPrimaryKeySelective(uo);
		}
		return Msg.success();
	}
	
}

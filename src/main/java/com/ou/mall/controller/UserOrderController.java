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
	
	/*
	 * 用户减价商品到购物车
	 */
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
		return Msg.success().add("msg", "添加成功");
	}
	
	/*
	 * 删除订单
	 *  实际上把用户订单状态修改为-1
	 */
	@ResponseBody
	@RequestMapping("delOrder")
	public Msg deleteOrder(@RequestParam("uoid")Integer uoid){

		UserOrder record = new UserOrder();
		record.setOrderId(uoid);
		record.setOrderStatus(-1);
		userOrderService.updateDelByPrimaryKeySelective(record);
		return Msg.success();
	}
	
	/*
	 * 批量删除用户购物车
	 */
	@ResponseBody
	@RequestMapping("delOrderBatch")
	public Msg delOrderBatch(@RequestParam("uoid")String uoid){
		if (uoid==null || "".equals(uoid)){
			return Msg.failure();
		}
		
		String[] uoids = uoid.split("-");
		UserOrder record = new UserOrder();
		for (String id : uoids){
			record.setOrderId(Integer.parseInt(id));
			record.setOrderStatus(-1);
			userOrderService.updateDelByPrimaryKeySelective(record);
		}
		
		return Msg.success();
	}
	
	/*
	 * 用户确认订单
	 */
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

	/*
	 * 更改订单状态
	 */
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
	
	/*
	 * 更改订单状态
	 */
	@ResponseBody
	@RequestMapping("updateStatus")
	public Msg updateOrder(@RequestParam("uoid") Integer uoid, @RequestParam("type") Integer type){
			UserOrder uo = new UserOrder();
			uo.setOrderId(uoid);
			uo.setOrderStatus(type);
			userOrderService.updateByPrimaryKeySelective(uo);
		return Msg.success();
	}
	
	/*
	 * 获取订单详情
	 */
	@ResponseBody
	@RequestMapping("getOrderById")
	public Msg getOrderById(@RequestParam("uoid") Integer uoid){
		UserOrder selectByPrimaryKey = userOrderService.selectByPrimaryKey(uoid);
		
		return Msg.success().add("order", selectByPrimaryKey);
	}
	
	/*
	 * 用户支付宝付款后调用
	 */
	@RequestMapping("updateOrderRedirect")
	public String updateOrderRedirect(HttpSession session, @RequestParam("uoid") String uoid
			, @RequestParam("type") Integer type){
		String[] uoids = uoid.split("-");
		for (String id : uoids){
			UserOrder uo = new UserOrder();
			uo.setOrderId(Integer.parseInt(id));
			uo.setOrderStatus(type);
			userOrderService.updateByPrimaryKeySelective(uo);
		}
		return "redirect:userOrder";
	}
}

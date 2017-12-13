package com.ou.mall.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.ProductExample;
import com.ou.mall.bean.User;
import com.ou.mall.bean.UserOrder;
import com.ou.mall.bean.UserOrderExample;
import com.ou.mall.service.ProductService;
import com.ou.mall.service.UserOrderService;
import com.ou.mall.service.UserService;

@Controller
public class PageController {
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserOrderService userOrderService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	

	@RequestMapping(value="index")
	public String index(@RequestParam(value="keyword", required=false) String keyword, HttpServletRequest request){
		ProductExample example = new ProductExample();
		
		if ("".equals(keyword) || keyword == null){
			keyword = null;
		}else{
			example.createCriteria().andProductTitleEqualTo(keyword);
		}
		example.createCriteria().andProductStatusEqualTo(0);
		List<Product> all = productService.selectByExample(example);
		request.setAttribute("Products", all);
		return "index";
	}
	
	@RequestMapping(value="login")
	public String login(User user){
		user = userService.getUserByUsername(user.getUserUsername());
		session.setAttribute("userSession", user);
		if (hasNotLogin()){
			return "redirect:login.jsp";
		}
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(User user){
		if (!hasNotLogin()){
			return "redirect:index.jsp";
		}
		user.setUserMoney(0);
		userService.insert(user);
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="logOut")
	public String logOut(){
		session.removeAttribute("userSession");
		return "redirect:login.jsp";
	}
	
	@RequestMapping("shoppingCar")
	public String shoppingCar(){
		if (hasNotLogin()){
			return "redirect:login.jsp";
		}
		
		Integer uid = ((User) session.getAttribute("userSession")).getUserId();
		if (uid == null){
			return "redirect:login.jsp";
		}
		UserOrderExample example = new UserOrderExample();
		example.createCriteria().andOrderStatusEqualTo(0);
		List<UserOrder> shoppingCar = userOrderService.selectByExampleWithProduct(example);
		request.setAttribute("shoppingCar", shoppingCar);
		return "shoppingCar";
	}
	
	@RequestMapping("payment")
	public String payment(@RequestParam("uoid") String uoid, @RequestParam("totalMoney") String totalMoney, 
			UserOrder userOrder){
		if (hasNotLogin()){
			return "redirect:login.jsp";
		}else if ("".equals(uoid) || "".equals(totalMoney) || uoid==null || totalMoney==null){
			return "redirect:index.jsp";
		}
		
		String[] uoids = uoid.split("-");
		for (String id : uoids){
			userOrder.setOrderId(Integer.parseInt(id));
			Date orderDateTime = new Date(System.currentTimeMillis());
			userOrder.setOrderDateTime(orderDateTime);
			userOrderService.updateOrderByPrimaryKey(userOrder);
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("uoid", uoid);
		return "payment";
	}
	
	
	@RequestMapping("userOrder")
	public String userOrderPage(@RequestParam(value="type", defaultValue="0") String type){
		if (hasNotLogin()){
			return "redirect:login.jsp";
		}
		User user = (User) session.getAttribute("userSession");
		Integer uid = user.getUserId(); 
		
		List<UserOrder> totalOrder = userOrderService.userOrderPage(uid, Integer.parseInt(type));
		request.setAttribute("userOrder", totalOrder);
		return "userOrder";
	}
	
	public boolean hasNotLogin(){
		if (session.getAttribute("userSession") == null){
			return true;
		}
		return false;
	}
}

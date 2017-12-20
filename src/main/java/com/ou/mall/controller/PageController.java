package com.ou.mall.controller;
/*
 * 本类主要负责页面跳转相关的逻辑
 */
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ou.mall.bean.Msg;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.ProductExample;
import com.ou.mall.bean.ProductExample.Criteria;
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
	

	/*
	 * 主页每页显示十五条信息
	 */
	@RequestMapping(value="index")
	public String index(@RequestParam(value="keyword", required=false) String keyword
			, @RequestParam(value = "pn", defaultValue = "1") Integer pn){
		// 使用PageHelper插件进行分页操作
		// 设置每页有15条数据
		PageHelper.startPage(pn, 15);
		ProductExample example = new ProductExample();
		Criteria createCriteria = example.createCriteria();
		
		// 查看是否关键词搜索
		if ("".equals(keyword) || keyword == null){
			keyword = null;
		}else{
			createCriteria.andProductTitleLike(keyword);
		}
		// 显示有图片1的商品
		// 商品状态 0 表示为上架状态， 1为下架状态， -1为删除  状态
		createCriteria.andProductImg1IsNotNull();
		createCriteria.andProductStatusEqualTo(0);
		List<Product> all = productService.selectByExample(example);   //根据条件选择查询
		PageInfo<Product> page = new PageInfo<Product>(all, 5);  // 分页条最多有5个
		request.setAttribute("pages", page);	// 将数据放入request 作用于供前台使用
		return "index";						// 转发回主页
	}
	
	
	@ResponseBody
	@RequestMapping(value="loglogin")
	public Msg login(@Valid User user, BindingResult result){
		if (result.hasErrors()){
			return Msg.failure().add("msg", "账号或密码错误");
		}
		user = userService.login(user);
		session.setAttribute("userSession", user);
		if (user == null){
			return Msg.failure().add("msg", "账号或密码错误");
		}
		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="regregister")
	public Msg register(@Valid User user, BindingResult result){
		if (result.hasErrors()){
			return Msg.failure();
		}
		user.setUserMoney(0.0);
		userService.insert(user);
		return login(user, result);
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
		example.createCriteria().andOrderStatusEqualTo(0).andOrderUidEqualTo(uid);
		
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
	public <T> String userOrderPage(@RequestParam(value="type", defaultValue="0") Integer type,
			@RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="pn", defaultValue="1") Integer pn){
		if (hasNotLogin()){
			return "redirect:login.jsp";
		}
//		设置分页大小
		PageHelper.startPage(pn, 5);
		User user = (User) session.getAttribute("userSession");
		Integer uid = user.getUserId(); 
		
		UserOrderExample example = new UserOrderExample();
		com.ou.mall.bean.UserOrderExample.Criteria createCriteria = example.createCriteria();
		if (type == 0){
			createCriteria.andOrderStatusNotEqualTo(-1);
			createCriteria.andOrderStatusNotEqualTo(0);
		}else{
			createCriteria.andOrderStatusEqualTo(type);
		}
		if (keyword != null && !"".equals(keyword)){
			createCriteria.andProductTitleLike(keyword);
		}
		createCriteria.andOrderUidEqualTo(uid);
		List<UserOrder> selectByExampleWithProduct = userOrderService.selectByExampleWithProduct(example);
		PageInfo<UserOrder> pageInfo = new PageInfo<UserOrder>(selectByExampleWithProduct, 5);
		request.setAttribute("pages", pageInfo);
		return "userOrder";
	}
	
	public boolean hasNotLogin(){
		if (session.getAttribute("userSession") == null){
			return true;
		}
		return false;
	}
	
	@RequestMapping("toLogin")
	public String toLogin(){
		return "redirect:login.jsp";
	}
	
	@RequestMapping("home")
	public String home(){
		if (hasNotLogin()){
			return "redirect:login.jsp";
		}
		return "home";
	}
}

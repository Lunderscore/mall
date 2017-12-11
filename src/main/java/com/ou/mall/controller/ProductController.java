package com.ou.mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.Product;
import com.ou.mall.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@ResponseBody
	@RequestMapping(value="product", method=RequestMethod.POST)
	public Msg addProduct(Product product){
		productService.addProduct(product);
		
		return Msg.failure();
	}
	
	@ResponseBody
	@RequestMapping(value="products", method=RequestMethod.GET)
	public Msg showProducts(HttpSession session){
		List<Product> all = productService.getAll();
		Msg msg = Msg.success();
		session.setAttribute("products", all);
		
		return msg;
	}	
}

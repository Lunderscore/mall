package com.ou.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.ProductExample;
import com.ou.mall.service.ProductService;
import com.ou.mall.service.UserOrderService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	UserOrderService userOrderService;
	
//	更新产品
	@RequestMapping(value="product/{id}", method=RequestMethod.PUT)
	public String updateProduct(Product product, @PathVariable("id") String pid){
		product.setProductId(Integer.parseInt(pid));
		productService.updateProduct(product);
    	return "redirect:../admin";
	}
	
	/*
	 * 根据主键获取商品信息
	 */
	@ResponseBody
	@RequestMapping(value="products/{pid}", method=RequestMethod.GET)
	public Msg getProduct(@PathVariable("pid") Integer pid){
		ProductExample example = new ProductExample();
		example.createCriteria().andProductIdEqualTo(pid);
		example.createCriteria().andProductStatusEqualTo(0);
		Product product = productService.selectAdminProductByPrimaryKey(example);
		Msg msg = Msg.success().add("product", product);
		return msg;
	}
	
}

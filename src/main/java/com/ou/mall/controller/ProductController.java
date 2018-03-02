package com.ou.mall.controller;

import com.ou.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	// @Autowired
	// UserOrderService userOrderService;
	
// //	更新产品
// 	@RequestMapping(value="product/{id}", method=RequestMethod.PUT)
// 	public String updateProduct(Product product, @PathVariable("id") String pid){
// 		product.setProductId(Integer.parseInt(pid));
// 		// productService.updateProduct(product);
//     	return "redirect:../admin";
// 	}
//
// 	/*
// 	 * 根据主键获取商品信息
// 	 */
// 	@ResponseBody
// 	@RequestMapping(value="products/{pid}", method=RequestMethod.GET)
// 	public Msg getProduct(@PathVariable("pid") Integer pid){
// 		ProductExample example = new ProductExample();
// 		example.createCriteria().andProductIdEqualTo(pid);
// 		example.createCriteria().andProductStatusEqualTo(0);
// 		// Product product = productService.selectAdminProductByPrimaryKey(example);
// 		// Msg msg = Msg.success().add("product", product);
// 		return null;
// 	}
	
}

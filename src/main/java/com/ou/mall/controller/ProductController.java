package com.ou.mall.controller;

import com.ou.mall.bean.Product;
import com.ou.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * 根据主键获取商品信息
	 *
	 * @param pid 商品主键
	 * @return
	 */
	@RequestMapping(value="products/{pid}", method= RequestMethod.GET)
	public String getProduct(Model model, @PathVariable Integer pid){
		Product product = productService.getProduct(pid);
		model.addAttribute("product", product);
		return "product";
	}
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

}

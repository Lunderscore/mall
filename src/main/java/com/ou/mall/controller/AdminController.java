package com.ou.mall.controller;

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
import com.ou.mall.bean.UploadedImageFile;
import com.ou.mall.service.ProductService;
import com.ou.mall.util.ImageUtil;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String getProducts(@RequestParam(value="search", required=false) String keyword){
		List<Product> products;
		ProductExample example = new ProductExample();
		if (keyword == null || "".equals(keyword)){
			keyword = null;
		}else{
			example.createCriteria().andProductTitleEqualTo(keyword);
		}
		
		example.createCriteria().andProductStatusNotEqualTo(-1);
		products = productService.selectByExample(example);
		request.setAttribute("products", products);
		return "admin";
	}
	
	@ResponseBody
	@RequestMapping(value="/products/{pid}", method=RequestMethod.GET)
	public Msg getProductByprimaryKey(@PathVariable("pid") Integer pid){
		ProductExample example = new ProductExample();
		example.createCriteria().andProductIdEqualTo(pid);
		example.createCriteria().andProductStatusNotEqualTo(-1);
		
		Product product = productService.selectAdminProductByPrimaryKey(example);
		
		Msg msg = Msg.success();
		msg.add("product", product);
		return msg;
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String addProduct(Product product){
		
		productService.addProduct(product);
		return "redirect:products";
	}
	
	@RequestMapping(value="/products/{pid}/{which}", method=RequestMethod.POST)
	public String updatePicture(UploadedImageFile image, @PathVariable("pid") Integer pid
			, @PathVariable("which") Integer which) throws Exception{
		String productImgPath = session.getServletContext().getRealPath("/data/img/products/" + which);
        String newImageName = ImageUtil.transfer(image, productImgPath, pid.toString());

        if (newImageName == null){
        	return "redirect:../../products";
        }
        Product product = new Product();
        product.setProductId(pid);
        String uri = "data/img/products/" + which + "/" + newImageName;
        if (which == 1){
        	product.setProductImg1(uri);
        }else if (which == 2){
        	product.setProductImg2(uri);
        }else if (which == 3){
        	product.setProductImg3(uri);
        }
        
        productService.updateByPrimaryKeySelective(product);
    	return "redirect:../../products";
	}
	
	
	
	@RequestMapping(value="/products/{pid}", method=RequestMethod.PUT)
	public String updateProduct(Product product, @PathVariable("pid") Integer pid){
		product.setProductId(pid);
		productService.updateByPrimaryKeySelective(product);
		
		return "redirect:../products";
	}
	
	@ResponseBody
	@RequestMapping("changeProductStatus")
	public Msg changeProductStatus(@RequestParam("pid") Integer pid, @RequestParam("status") Integer status){
		Product product = new Product();
		product.setProductId(pid);
		product.setProductStatus(status);
		
		productService.updateByPrimaryKeySelective(product);
		return Msg.success();
	}
}

package com.ou.mall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.UploadedImageFile;
import com.ou.mall.service.ProductService;
import com.ou.mall.util.ImageUtil;

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
	
	@ResponseBody
	@RequestMapping(value="mainPicture/{id}")
	public Msg uploadMainPic(UploadedImageFile image, HttpSession session, @PathVariable("id") String pid) throws IllegalStateException, IOException{
		String productImgPath = session.getServletContext().getRealPath("/data/img/product/");
        String newImageName = ImageUtil.transfer(image, productImgPath, pid+"main");
        
        if (newImageName == null){
        	return Msg.failure();
        }
        productService.uploadMainPic(Integer.parseInt(pid), "data/img/product/" + newImageName);
        return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="secPicture/{id}")
	public Msg uploadSecPic(UploadedImageFile image, HttpSession session, @PathVariable("id") String pid) throws IllegalStateException, IOException{
		String productImgPath = session.getServletContext().getRealPath("/data/img/product/");
        String newImageName = ImageUtil.transfer(image, productImgPath, pid+"sec");
        
        if (newImageName == null){
        	return Msg.failure();
        }
        productService.uploadSecPic(Integer.parseInt(pid), "data/img/product/" + newImageName);
        return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="thiPicture/{id}")
	public Msg uploadThiPic(UploadedImageFile image, HttpSession session, @PathVariable("id") String pid) throws IllegalStateException, IOException{
		String productImgPath = session.getServletContext().getRealPath("/data/img/product/");
        String newImageName = ImageUtil.transfer(image, productImgPath, pid+"thi");

        if (newImageName == null){
        	return Msg.failure();
        }
        productService.uploadThiPic(Integer.parseInt(pid), "data/img/product/" + newImageName);
        return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="product/{id}", method=RequestMethod.PUT)
	public Msg updateProduct(Product product, @PathVariable("id") String pid){
		
		product.setProductId(Integer.parseInt(pid));
		
		productService.updateProduct(product);
        return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="delProduct", method=RequestMethod.DELETE)
	public Msg delProduct(Product product){
		
		productService.delProduct(product);
        return Msg.success();
	}
	
	
}
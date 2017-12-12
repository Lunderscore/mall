package com.ou.mall.controller;

import java.io.IOException;
import java.util.List;

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
	
	
	@RequestMapping(value="indexProducts", method=RequestMethod.GET)
	public String showIndexProducts(HttpSession session, @RequestParam(value="search", required=false) String keyword){
		
		if (keyword == null || "".equals(keyword)){
			keyword = null;
		}
		
		List<Product> all = productService.getIndexProducts(keyword);
		session.setAttribute("indexProducts", all);
		
		return "indexMapping";
	}
	
	@RequestMapping(value="admin", method=RequestMethod.GET)
	public String showAdminProducts(HttpSession session, @RequestParam(value="search", required=false) String keyword){
		
		if (keyword == null || "".equals(keyword)){
			keyword = null;
		}

		List<Product> all = productService.getAdminProducts(keyword);
		session.setAttribute("adminProducts", all);
		
		return "adminMapping";
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
	
	@ResponseBody
	@RequestMapping(value="getProductByIDJSON", method=RequestMethod.GET)
	public Msg getProductByIDJSON(@RequestParam("pid") Integer pid){
		
		Product product = productService.getProductByID(pid);
		Msg msg = Msg.success().add("product", product);
		
		String mainPic = productService.getMainPic(pid);
		String secPic = productService.getSubPic(pid, 2);
		String thiPic = productService.getSubPic(pid, 3);
		
		msg.add("mainPic", mainPic);
		msg.add("secPic", secPic);
		msg.add("thiPic", thiPic);
		return msg;
	}
}

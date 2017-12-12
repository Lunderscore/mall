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
		
		return Msg.success();
	}
	
	
	@RequestMapping(value="index", method=RequestMethod.GET)
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
	
	@RequestMapping(value="mainPicture")
	public String uploadMainPic(UploadedImageFile image, HttpSession session, @RequestParam("pid") String pid) throws IllegalStateException, IOException{
		String productImgPath = session.getServletContext().getRealPath("/data/img/product/");
        String newImageName = ImageUtil.transfer(image, productImgPath, pid+"main");
        
        if (newImageName == null){
        	return "redirect:admin";
        }
        productService.uploadMainPic(Integer.parseInt(pid), "data/img/product/" + newImageName);
    	return "redirect:admin";
	}
	
	@RequestMapping(value="secPicture")
	public String uploadSecPic(UploadedImageFile image, HttpSession session, @RequestParam("pid") String pid) throws IllegalStateException, IOException{
		String productImgPath = session.getServletContext().getRealPath("/data/img/product/");
        String newImageName = ImageUtil.transfer(image, productImgPath, pid+"sec");
        
        if (newImageName == null){
        	return "redirect:admin";
        }
        productService.uploadSecPic(Integer.parseInt(pid), "data/img/product/" + newImageName);
    	return "redirect:admin";
	}
	
	@RequestMapping(value="thiPicture")
	public String uploadThiPic(UploadedImageFile image, HttpSession session, @RequestParam("pid") String pid) throws IllegalStateException, IOException{
		String productImgPath = session.getServletContext().getRealPath("/data/img/product/");
        String newImageName = ImageUtil.transfer(image, productImgPath, pid+"thi");

        if (newImageName == null){
        	return "redirect:admin";
        }
        productService.uploadThiPic(Integer.parseInt(pid), "data/img/product/" + newImageName);
    	return "redirect:admin";
	}
	
	@RequestMapping(value="product/{id}", method=RequestMethod.PUT)
	public String updateProduct(Product product, @PathVariable("id") String pid){
		
		product.setProductId(Integer.parseInt(pid));
		
		productService.updateProduct(product);
    	return "redirect:../admin";
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
	
	@ResponseBody
	@RequestMapping("changeProductStatus")
	public Msg changeProductStatus(@RequestParam("pid") Integer pid, @RequestParam("status") Integer status){
		productService.changeProductStatus(pid, status);
		
		return Msg.success();
		
	}
}

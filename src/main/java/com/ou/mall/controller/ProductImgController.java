package com.ou.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ou.mall.bean.Msg;
import com.ou.mall.service.ProductImgService;

@Controller
public class ProductImgController {
	@Autowired
	ProductImgService productImgService;
	
	@ResponseBody
	@RequestMapping("getProductImg")
	public Msg getProductImg(@RequestParam("pid") Integer pid, @RequestParam("which") Integer which){
		String productImg = productImgService.getProductImg(pid, which);
		
		return Msg.success().add("imgUri", productImg);
	}
	
}

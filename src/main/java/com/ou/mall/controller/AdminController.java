package com.ou.mall.controller;
/*
 * 本类负责维护管理员页面
 */
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ou.mall.bean.Msg;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.ProductExample;
import com.ou.mall.bean.ProductExample.Criteria;
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
	
	
/*
 * 获取所有商品的信息
 * 显示五个分页
 * 每页有5个商品
 */
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String getProducts(@RequestParam(value="keyword", required=false) String keyword
			, @RequestParam(value = "pn", defaultValue = "1") Integer pn){
		PageHelper.startPage(pn, 5);
		List<Product> products;
		ProductExample example = new ProductExample();
		Criteria createCriteria = example.createCriteria();
		if (keyword == null || "".equals(keyword)){
			keyword = null;
		}else{
			createCriteria.andProductTitleLike(keyword);
		}
		createCriteria.andProductStatusNotEqualTo(-1);
		products = productService.selectByExample(example);
		
		PageInfo<Product> page = new PageInfo<Product>(products, 5);
		request.setAttribute("pages", page);
		return "admin";
	}
	
	/*
	 * 通过主键获取商品
	 */
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
	
	/*
	 * 增加商品
	 */
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String addProduct(Product product){
		
		productService.addProduct(product);
		return "redirect:products";
	}
	
	/*
	 * 上传图片
	 */
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
	
	/*
	 * 更新产品
	 */
	
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

package com.ou.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.Product;
import com.ou.mall.bean.ProductExample;
import com.ou.mall.bean.ProductExample.Criteria;
import com.ou.mall.bean.ProductImg;
import com.ou.mall.bean.ProductImgExample;
import com.ou.mall.bean.UserAvatar;
import com.ou.mall.bean.UserAvatarExample;
import com.ou.mall.dao.ProductImgMapper;
import com.ou.mall.dao.ProductMapper;

@Service
public class ProductService {

	@Autowired
	ProductMapper productMapper;

	@Autowired
	ProductImgMapper productImgMapper;

	public void addProduct(Product product) {
		productMapper.insert(product);
	}

	public List<Product> getIndexProducts(String title) {

		ProductExample example = new ProductExample();
		Criteria createCriteria = example.createCriteria();

		if (title != null) {
			createCriteria.andProductTitleEqualTo(title);
		}
		createCriteria.andProductImgIsNotNull();
		createCriteria.andProductDelEqualTo(0);
		List<Product> selectByExample = productMapper.selectByExample(example);

		return selectByExample;
	}

	public List<Product> getAdminProducts(String title) {

		ProductExample example = new ProductExample();
		Criteria createCriteria = example.createCriteria();

		if (title != null) {
			createCriteria.andProductTitleEqualTo(title);
		}
		createCriteria.andProductDelEqualTo(0);
		List<Product> selectByExample = productMapper.selectByExample(example);

		return selectByExample;
	}

	public void uploadMainPic(Integer pid, String productImg) {
		Product record = new Product();
		record.setProductImg(productImg);

		ProductExample example = new ProductExample();
		example.createCriteria().andProductIdEqualTo(pid);
		productMapper.updateByExampleSelective(record, example);
		return;
	}

	public void createProductImg(Integer pid) {
		ProductImgExample example = new ProductImgExample();
		example.createCriteria().andImgPidEqualTo(pid);

		if (productImgMapper.selectByExample(example).isEmpty()) {
			ProductImg productImg = new ProductImg();
			productImg.setImgPid(pid);
			productImgMapper.insert(productImg);
		}
	}

	public void uploadSecPic(Integer pid, String imgImg2) {
		createProductImg(pid);

		ProductImg record = new ProductImg();
		record.setImgImg2(imgImg2);

		ProductImgExample example = new ProductImgExample();
		example.createCriteria().andImgPidEqualTo(pid);
		productImgMapper.updateByExampleSelective(record, example);
	}

	public void uploadThiPic(Integer pid, String imgImg3) {
		createProductImg(pid);

		ProductImg record = new ProductImg();
		record.setImgImg3(imgImg3);

		ProductImgExample example = new ProductImgExample();
		example.createCriteria().andImgPidEqualTo(pid);
		productImgMapper.updateByExampleSelective(record, example);
	}

	public void updateProduct(Product product) {
		productMapper.updateByPrimaryKeySelective(product);
	}

	public void delProduct(Product product) {
		product.setProductDel(1);
		productMapper.updateByPrimaryKeySelective(product);
	}

	public Product getProductByID(Integer pid) {
		Product product = productMapper.selectByPrimaryKey(pid);
		return product;
	}

	public String getMainPic(Integer ppid) {
		Product productImg = productMapper.selectByPrimaryKey(ppid);

		return productImg == null ? null : productImg.getProductImg();
	}

	public String getSubPic(Integer ppid, int type) {
		ProductImgExample example = new ProductImgExample();
		example.createCriteria().andImgPidEqualTo(ppid);

		if (productImgMapper.selectByExample(example).isEmpty()) {
			return null;
		}
		ProductImg productImg = productImgMapper.selectByExample(example).get(0);

		if (type == 2) {
			return productImg.getImgImg2();
		} else if (type == 3) {
			return productImg.getImgImg3();
		}
		return null;
	}

}

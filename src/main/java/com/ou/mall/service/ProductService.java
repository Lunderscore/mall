package com.ou.mall.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.Product;
import com.ou.mall.bean.ProductExample;
import com.ou.mall.bean.ProductExample.Criteria;
import com.ou.mall.dao.ProductMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProductService
 * @author: kpkym
 * date: 2018/3/2
 * time: 8:40
 */
@Service
public class ProductService {
	@Autowired
	ProductMapper productMapper;

	public List<Product> listAdminProduct(Integer pn, String keyword) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductStatusNotEqualTo(Product.STATUS_DELETE);
		if (!"".equals(keyword)) {
			criteria.andProductTitleLike("%" + keyword + "%");
		}
		List<Product> products = productMapper.selectByExample(example);
		return products;
	}

	public List<Product> listIndexProduct(Integer pn, String keyword) {
		// PageHelper.startPage(pn, 5);
		// Criteria criteria =
		// criteria.andProductStatusNotEqualTo(Product.STATUS_DELETE);
		// if (!"".equals(keyword)) {
		// 	criteria.andProductTitleLike("%" + keyword + "%");
		// }
		// List<Product> products = productMapper.selectByExample(example);
		return null;
	}

	/**
	 * 通过主键获取商品
	 *
	 * @param pid
	 * @return null or product
	 */
	public Product getProduct(Integer pid) {
		ProductExample example = new ProductExample();
		example.createCriteria().andProductIdEqualTo(pid);
		example.createCriteria().andProductStatusNotEqualTo(Product.STATUS_DELETE);
		List<Product> products = productMapper.selectByExample(example);

		return products.size() == 0 ? null : products.get(0);
	}

	public String getMainPic(Integer ppid) {
		Product productImg = productMapper.selectByPrimaryKey(ppid);

		return productImg == null ? null : productImg.getProductImg1();
	}

	public void updateProduct(Product product) {
		productMapper.updateByPrimaryKeySelective(product);
	}


	public List<Product> getAdminProducts() {
		ProductExample example = new ProductExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andProductStatusNotEqualTo(2);
		
		List<Product> selectByExample = productMapper.selectByExample(example);
		return selectByExample;
	}
	
	public Product selectAdminProductByPrimaryKey(ProductExample example) {
		List<Product> selectByExample = productMapper.selectByExample(example);
		return selectByExample.isEmpty() ? new Product() : selectByExample.get(0);
	}
	
	public void addProduct(Product product) {
		productMapper.insert(product);
	}

	public void updateByPrimaryKeySelective(Product product) {
		productMapper.updateByPrimaryKeySelective(product);
	}
}

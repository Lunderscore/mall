package com.ou.mall.service;

import com.github.pagehelper.PageHelper;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.ProductExample;
import com.ou.mall.bean.ProductExample.Criteria;
import com.ou.mall.dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductService
 *
 * @author: kpkym
 * date: 2018/3/2
 * time: 8:40
 */
@Service
public class ProductService {
	@Autowired
	ProductMapper productMapper;

	/**
	 * 返回status不为-1的商品
	 *
	 * @param pn 页码
	 * @param keyword 关键字模糊查询
	 * @return
	 */
	public List<Product> listAdminProduct(Integer pn, String keyword) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductStatusNotEqualTo(Product.STATUS_DELETE);
		if (!"".equals(keyword)) {
			criteria.andProductTitleLike("%" + keyword + "%");
		}
		PageHelper.startPage(pn, 5);
		return productMapper.selectByExample(example);
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

	/**
	 * 添加商品
	 *
	 * @param product
	 */
	public void addProduct(Product product) {
		product.setProductStatus(Product.STATUS_NORMAL);
		productMapper.insert(product);
	}

	/**
	 * 修改商品
	 *
	 * @param product 需要修改的商品
	 * @param pid 商品id
	 */
	public void updateProduct(Product product, Integer pid) {
		product.setProductId(pid);
		productMapper.updateByPrimaryKeySelective(product);
	}

	/**
	 * 删除或下架 商品
	 *
 	 * @param pid 商品id
	 */
	public void delProduct(Integer pid, Integer status) {
		Product product = getProduct(pid);
		product.setProductStatus(status);
		productMapper.updateByPrimaryKey(product);
	}
}

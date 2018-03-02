package com.ou.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.ProductExample;
import com.ou.mall.bean.ProductExample.Criteria;
import com.ou.mall.dao.ProductMapper;
import com.ou.mall.service.ProductService;
import com.ou.mall.status.ProductStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductMapper productMapper;

	@Value("${admin.product.size}")
	Integer adminProductSize;
	@Value("${index.product.size}")
	Integer indexProductSize;

	@Override
	public List<Product> listAdminProduct(Integer pn, String keyword) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo(ProductStatusEnum.del.getValue());
		if (!"".equals(keyword)) {
			criteria.andTitleLike("%" + keyword + "%");
		}
		PageHelper.startPage(pn, adminProductSize);
		return productMapper.selectByExample(example);
	}

	@Override
	public List<Product> listIndexProduct(Integer pn, String keyword) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(ProductStatusEnum.sale.getValue());
		if (!"".equals(keyword)) {
			criteria.andTitleLike("%" + keyword + "%");
		}
		PageHelper.startPage(pn, indexProductSize);
		return productMapper.selectByExample(example);
	}

	@Override
	public Product getProduct(Integer pid) {
		ProductExample example = new ProductExample();
		example.createCriteria().andIdEqualTo(pid);
		example.createCriteria().andStatusNotEqualTo(ProductStatusEnum.del.getValue());
		List<Product> products = productMapper.selectByExample(example);

		return products.size() == 0 ? null : products.get(0);
	}

	@Override
	public void addProduct(Product product) {
		product.setStatus(ProductStatusEnum.sale.getValue());
		productMapper.insert(product);
	}

	@Override
	public void updateProduct(Product product, Integer pid) {
		product.setId(pid);
		productMapper.updateByPrimaryKeySelective(product);
	}

	@Override
	public void delProduct(Integer pid, ProductStatusEnum status) {
		Product product = getProduct(pid);
		product.setStatus(status.getValue());
		productMapper.updateByPrimaryKey(product);
	}
}

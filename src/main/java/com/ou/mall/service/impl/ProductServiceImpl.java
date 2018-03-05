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

	@Value("${index.product.size}")
	Integer indexProductSize;

	@Override
	public List<Product> listProduct(Integer pn, String keyword) {
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
		example.createCriteria().andStatusEqualTo(ProductStatusEnum.sale.getValue());
		List<Product> products = productMapper.selectByExample(example);
		return products.size() == 0 ? null : products.get(0);
	}
}

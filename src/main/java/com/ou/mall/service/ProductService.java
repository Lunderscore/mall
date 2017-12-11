package com.ou.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.Product;
import com.ou.mall.dao.ProductMapper;

@Service
public class ProductService {

	@Autowired
	ProductMapper productMapper;
	
	public void addProduct(Product product) {
		productMapper.insert(product);
	}

	public List<Product> getAll() {
		List<Product> selectByExample = productMapper.selectByExample(null);		
		
		return selectByExample;
	}

}

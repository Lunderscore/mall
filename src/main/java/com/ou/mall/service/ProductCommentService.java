package com.ou.mall.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.ProductComment;
import com.ou.mall.bean.ProductCommentExample;
import com.ou.mall.dao.ProductCommentMapper;

@Service
public class ProductCommentService {

	@Autowired
	ProductCommentMapper productCommentMapper;
	
	public void addComment(ProductComment record){
		productCommentMapper.insert(record);
	}
	
	public List<ProductComment> getCommentByExample(ProductCommentExample example){
		return productCommentMapper.selectByExampleWithUser(example);
	}
}

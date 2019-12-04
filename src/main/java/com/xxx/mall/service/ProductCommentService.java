package com.xxx.mall.service;


import com.xxx.mall.bean.po.ProductComment;
import com.xxx.mall.bean.po.ProductCommentExample;
import com.xxx.mall.mapper.ProductCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductCommentService {

    @Autowired
    ProductCommentMapper productCommentMapper;

    public void addComment(ProductComment record) {
        productCommentMapper.insert(record);
    }

    public List<ProductComment> getCommentByExample(ProductCommentExample example) {
        return productCommentMapper.selectByExampleWithUser(example);
    }
}

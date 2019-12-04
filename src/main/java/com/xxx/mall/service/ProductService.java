package com.xxx.mall.service;

import com.xxx.mall.bean.po.Product;
import com.xxx.mall.bean.po.ProductExample;
import com.xxx.mall.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public List<Product> selectByExample(ProductExample example) {
        List<Product> selectByExample = productMapper.selectByExample(example);
        return selectByExample;
    }

    public String getMainPic(Integer ppid) {
        Product productImg = productMapper.selectByPrimaryKey(ppid);

        return productImg == null ? null : productImg.getProductImg1();
    }

    @Transactional
    public void updateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }


    /////////////////////////////////////////
    public List<Product> getAdminProducts() {
        ProductExample example = new ProductExample();
        ProductExample.Criteria createCriteria = example.createCriteria();
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

    @Transactional
    public void updateByPrimaryKeySelective(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }
}

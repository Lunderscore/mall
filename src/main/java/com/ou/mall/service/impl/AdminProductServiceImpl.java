package com.ou.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.ProductExample;
import com.ou.mall.dao.ProductMapper;
import com.ou.mall.service.AdminProductService;
import com.ou.mall.status.ProductStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: kpkym
 * date: 2018/3/5
 * time: 11:20
 */
@Service
public class AdminProductServiceImpl implements AdminProductService {
    @Autowired
    ProductMapper productMapper;

    @Value("${admin.product.size}")
    Integer adminProductSize;

    @Override
    public List<Product> listProduct(Integer pn, String keyword) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(ProductStatusEnum.del.getValue());
        if (!"".equals(keyword)) {
            criteria.andTitleLike("%" + keyword + "%");
        }
        PageHelper.startPage(pn, adminProductSize);
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
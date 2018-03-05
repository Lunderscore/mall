package com.ou.mall.service;

import com.ou.mall.bean.Product;
import com.ou.mall.status.ProductStatusEnum;

import java.util.List;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 22:33
 */
public interface ProductService {
    /**
     * 返回status为0的商品
     *
     * @param pn      页码
     * @param keyword 关键字模糊查询
     * @return
     */
    List<Product> listProduct(Integer pn, String keyword);

    /**
     * 通过主键获取状态为0的商品
     *
     * @param pid
     * @return null or product
     */
    Product getProduct(Integer pid);
}

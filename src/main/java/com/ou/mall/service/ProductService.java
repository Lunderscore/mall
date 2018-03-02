package com.ou.mall.service;

import com.ou.mall.bean.Product;
import com.ou.mall.status.ProductStatus;

import java.util.List;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 22:33
 */
public interface ProductService {
    /**
     * 返回status不为-1的商品
     *
     * @param pn      页码
     * @param keyword 关键字模糊查询
     * @return
     */
    List<Product> listAdminProduct(Integer pn, String keyword);

    /**
     * 返回status为0的商品
     *
     * @param pn      页码
     * @param keyword 关键字模糊查询
     * @return
     */
    List<Product> listIndexProduct(Integer pn, String keyword);

    /**
     * 通过主键获取商品
     *
     * @param pid
     * @return null or product
     */
    Product getProduct(Integer pid);

    /**
     * 添加商品
     *
     * @param product
     */
    void addProduct(Product product);

    /**
     * 修改商品
     *
     * @param product 需要修改的商品
     * @param pid     商品id
     */
    void updateProduct(Product product, Integer pid);

    /**
     * 删除或下架 商品
     *
     * @param pid 商品id
     */
    void delProduct(Integer pid, ProductStatus status);
}

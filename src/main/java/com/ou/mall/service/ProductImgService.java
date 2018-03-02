package com.ou.mall.service;

import com.ou.mall.bean.ProductImg;
import com.ou.mall.exception.ErrorImgCountException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 20:29
 */
public interface ProductImgService {
    /**
     * @param pid 商品id
     * @return 该商品图片list
     */
    List<ProductImg> listProductImg(Integer pid);

    /**
     * @param piid 商品ProductImg id
     * @return 该商品图片
     */
    ProductImg getProductImg(Integer piid);

    /**
     * @param file 需要保存的图片
     * @param dir  保存的目录
     * @param pid  商品id
     * @throws IOException
     * @throws ErrorImgCountException
     */
    void insertProductImg(MultipartFile file, String dir, Integer pid) throws IOException, ErrorImgCountException;

    /**
     * @param file 需要修改的新图片
     * @param dir 保存的目录
     * @param piid ProductImg id
     */
    void updateProductImg(MultipartFile file, String dir, Integer piid);
}
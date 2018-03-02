package com.ou.mall.service;

import com.ou.mall.exception.ErrorImgCountException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 20:29
 */
public interface ProductImgService {
    /**
     * @param file 需要保存的图片
     * @param dir  保存的目录
     * @param pid  商品id
     * @throws IOException
     * @throws ErrorImgCountException
     */
    void insertProductImg(MultipartFile file, String dir, Integer pid) throws IOException, ErrorImgCountException;
}
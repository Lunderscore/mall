package com.ou.mall.service.impl;

import com.ou.mall.bean.ProductImg;
import com.ou.mall.bean.ProductImgExample;
import com.ou.mall.dao.ProductImgMapper;
import com.ou.mall.exception.ErrorImgCountException;
import com.ou.mall.service.ProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 20:31
 */
@Service
public class ProductImgServiceImpl implements ProductImgService {
    @Autowired
    ProductImgMapper productImgMapper;

    @Value("${productImg.maxImg}")
    Integer maxImg;

    @Override
    public void insertProductImg(MultipartFile file, String dir, Integer pid) throws IOException, ErrorImgCountException {
        ProductImgExample example = new ProductImgExample();
        ProductImgExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        long count = productImgMapper.countByExample(example);
        // 如果该商品图片超过设置图片则抛出异常
        if (count >= maxImg) {
            throw new ErrorImgCountException("图片数量超过" + maxImg);
        }
        // 根据正则表达式切割字符串取出后缀名
        String[] split = file.getOriginalFilename().split("\\.");
        String suffix = split[split.length - 1];
        String uuid = UUID.randomUUID().toString();
        String fileLocation = dir + File.separator + uuid + "." + suffix;
        ProductImg productImg = new ProductImg();
        productImg.setImg(fileLocation);
        productImg.setPid(pid);
        // 先插入数据库 后保存图片
        productImgMapper.insert(productImg);
        file.transferTo(new File(fileLocation));
    }
}
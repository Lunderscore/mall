package com.ou.mall.service.impl;

import com.ou.mall.bean.ProductImg;
import com.ou.mall.bean.ProductImgExample;
import com.ou.mall.dao.ProductImgMapper;
import com.ou.mall.exception.ErrorImgCountException;
import com.ou.mall.service.ProductImgService;
import org.mybatis.generator.codegen.ibatis2.model.ExampleGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
    public List<ProductImg> listProductImg(Integer pid) {
        ProductImgExample example = new ProductImgExample();
        ProductImgExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        List<ProductImg> productImgs = productImgMapper.selectByExample(example);
        return productImgs;
    }

    @Override
    public ProductImg getProductImg(Integer piid) {
        return productImgMapper.selectByPrimaryKey(piid);
    }

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

    @Override
    public void updateProductImg(MultipartFile file, String dir, Integer piid) {
        ProductImg productImg = getProductImg(piid);
        // 拿出原来的图片
        String databaseImg = productImg.getImg();
        // 根据正则表达式切割字符串取出后缀名
        String[] split = file.getOriginalFilename().split("\\.");
        String suffix = split[split.length - 1];
        String uuid = UUID.randomUUID().toString();
        String fileLocation = dir + File.separator + uuid + "." + suffix;
        productImg.setImg(fileLocation);
        productImgMapper.updateByPrimaryKey(productImg);
        // 删除原来的图片
        new File(databaseImg).delete();
    }
}
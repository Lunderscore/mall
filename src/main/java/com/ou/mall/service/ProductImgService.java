package com.ou.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.ProductImg;
import com.ou.mall.bean.ProductImgExample;
import com.ou.mall.bean.ProductImgExample.Criteria;
import com.ou.mall.dao.ProductImgMapper;

@Service
public class ProductImgService {
	@Autowired
	ProductImgMapper productImgMapper;
	
	public String getProductImg(Integer pid, Integer which) {
		ProductImgExample example = new ProductImgExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andImgPidEqualTo(pid);
		List<ProductImg> selectByExample = productImgMapper.selectByExample(example);
		if (selectByExample.isEmpty()){
			return null;
		}
		
		if (which == 2){
			return selectByExample.get(0).getImgImg2();
		}else if (which == 3){
			return selectByExample.get(0).getImgImg3();
		}
		return null;

	}

}

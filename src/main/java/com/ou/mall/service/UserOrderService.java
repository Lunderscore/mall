package com.ou.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ou.mall.bean.Product;
import com.ou.mall.bean.UserOrder;
import com.ou.mall.bean.UserOrderExample;
import com.ou.mall.dao.ProductMapper;
import com.ou.mall.dao.UserOrderMapper;

@Service
public class UserOrderService {

	@Autowired
	UserOrderMapper userOrderMapper;
	
	@Autowired
	ProductMapper productMapper;
	
	public void createOrder(Integer uid, Integer pid, Integer num) {
		UserOrder record = new UserOrder();
		record.setOrderPid(pid);
		record.setOrderUid(uid);
		record.setOrderNumber(num);
		record.setOrderStatus(0);
		userOrderMapper.insert(record);
		
		Product product = productMapper.selectByPrimaryKey(pid);
		product.setProductStock(product.getProductStock()-num);
		productMapper.updateByPrimaryKey(product);
	}
	
	public void updateOrderByPrimaryKey(UserOrder userOrder){
		userOrderMapper.updateByPrimaryKeySelective(userOrder);
	}

	public void updateByPrimaryKeySelective(UserOrder record){
		userOrderMapper.updateByPrimaryKeySelective(record);
	}
	
	public List<UserOrder> selectByExampleWithProduct(UserOrderExample example) {
		return userOrderMapper.selectByExampleWithProduct(example);
	}

	public void deleteOrder(Integer uoid) {
		userOrderMapper.deleteByPrimaryKey(uoid);
	}

	public List<UserOrder> userOrderPage(Integer uid, Integer type) {
		UserOrderExample example = new UserOrderExample();
		if (type == 0){
			example.createCriteria().andOrderStatusNotEqualTo(-1);
		}else{
			example.createCriteria().andOrderStatusEqualTo(type);
		}
		
		example.createCriteria().andOrderUidEqualTo(uid);
		List<UserOrder> selectByExampleWithProduct = userOrderMapper.selectByExampleWithProduct(example);
		return selectByExampleWithProduct.isEmpty() ? null : selectByExampleWithProduct;		
	}
}

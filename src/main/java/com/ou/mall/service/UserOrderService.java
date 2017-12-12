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

	public List<UserOrder> getShoppingCar(Integer uid) {
		UserOrderExample example = new UserOrderExample();
		example.createCriteria().andOrderStatusEqualTo(0);
		
		List<UserOrder> selectByExampleWithProduct = userOrderMapper.selectByExampleWithProduct(example);
		return selectByExampleWithProduct.isEmpty() ? null : selectByExampleWithProduct;
	}

	public void deleteOrder(Integer uoid) {
		userOrderMapper.deleteByPrimaryKey(uoid);
	}

	public List<UserOrder> totalOrder(Integer uid) {
		UserOrderExample example = new UserOrderExample();
		example.createCriteria().andOrderStatusNotEqualTo(0);
		example.createCriteria().andOrderUidEqualTo(uid);
		
		List<UserOrder> selectByExampleWithProduct = userOrderMapper.selectByExampleWithProduct(example);
		return selectByExampleWithProduct.isEmpty() ? null : selectByExampleWithProduct;		
	}
	public List<UserOrder> waitPay(Integer uid) {
		UserOrderExample example = new UserOrderExample();
		example.createCriteria().andOrderStatusEqualTo(1);
		example.createCriteria().andOrderUidEqualTo(uid);
		
		List<UserOrder> selectByExampleWithProduct = userOrderMapper.selectByExampleWithProduct(example);
		return selectByExampleWithProduct.isEmpty() ? null : selectByExampleWithProduct;		
	}
	public List<UserOrder> waitDeliver(Integer uid) {
		UserOrderExample example = new UserOrderExample();
		example.createCriteria().andOrderStatusEqualTo(2);
		example.createCriteria().andOrderUidEqualTo(uid);
		
		List<UserOrder> selectByExampleWithProduct = userOrderMapper.selectByExampleWithProduct(example);
		return selectByExampleWithProduct.isEmpty() ? null : selectByExampleWithProduct;		
	}
	public List<UserOrder> waitConfirm(Integer uid) {
		UserOrderExample example = new UserOrderExample();
		example.createCriteria().andOrderStatusEqualTo(3);
		example.createCriteria().andOrderUidEqualTo(uid);
		
		List<UserOrder> selectByExampleWithProduct = userOrderMapper.selectByExampleWithProduct(example);
		return selectByExampleWithProduct.isEmpty() ? null : selectByExampleWithProduct;		
		
	}
	public List<UserOrder> waitComment(Integer uid) {
		UserOrderExample example = new UserOrderExample();
		example.createCriteria().andOrderStatusEqualTo(4);
		example.createCriteria().andOrderUidEqualTo(uid);
		
		List<UserOrder> selectByExampleWithProduct = userOrderMapper.selectByExampleWithProduct(example);
		return selectByExampleWithProduct.isEmpty() ? null : selectByExampleWithProduct;		
	}
}

package com.briup.estore.service.impl;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.dao.OrderFormMapper;
import com.briup.estore.service.IOrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFormServiceImpl implements IOrderFormService{
	@Autowired
	private OrderFormMapper orderFormMapper;
	
	@CacheEvict(value = "selectOrderByCustId",key = "'inertOrderForm'",allEntries = true)
	@Override
	public void inertOrderForm(OrderForm orderForm) {
		orderFormMapper.insertOrder(orderForm);
		//session.commit();
	}
	
	@Cacheable(value = "selectOrderByCustId",key = "'selectOrderByCustId'")
	@Override
	public List<OrderForm> selectOrderByCustId(int custid) {
		List<OrderForm> orderlist = orderFormMapper.selectOrderByCustId(custid);
		
		return orderlist;
	}
	
	@CacheEvict(value = "selectOrderByCustId",key = "'deleteFormByIddeleteFormById'",allEntries = true)
	@Override
	public void deleteFormById(int orderFormid) {
		orderFormMapper.deleteOrderFormById(orderFormid);
	}
}

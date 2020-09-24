package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.dao.OrderLineMapper;
import com.briup.estore.service.IOrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class OrderLineServiceImpl implements IOrderLineService{
	@Autowired
	private OrderLineMapper orderLineMapper;
	
	@Override
	public void insertLine(OrderLine orderLine) {
		orderLineMapper.insertLine(orderLine);
	}
	
	@Override
	public List<OrderLine> selectLine(int id) {
		List<OrderLine> orderLinelist = orderLineMapper.selectOrderLineById(id);
		return orderLinelist;
	}
	
	@Override
	public void deleteOrderLineByFromId(int orderFormId) {
		orderLineMapper.deleteOrderLineByFromId(orderFormId);
	}
}

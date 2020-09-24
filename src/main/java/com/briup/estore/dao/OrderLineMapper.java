package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.OrderLine;

public interface OrderLineMapper {
	void insertLine(OrderLine orderLine);
	List<OrderLine> selectOrderLineById(int id);
	void deleteOrderLineByFromId(int orderForm_id);
}

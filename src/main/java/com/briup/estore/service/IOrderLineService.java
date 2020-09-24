package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.OrderLine;

public interface IOrderLineService {
	void insertLine(OrderLine orderLine);
	List<OrderLine> selectLine(int id);
	void deleteOrderLineByFromId(int orderFormId);
}

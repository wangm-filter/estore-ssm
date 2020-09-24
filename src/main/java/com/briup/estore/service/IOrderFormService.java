package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.OrderForm;

public interface IOrderFormService {
	void inertOrderForm(OrderForm orderForm);
	List<OrderForm> selectOrderByCustId(int custid);
	void deleteFormById(int orderFormid);
}

package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.OrderForm;

public interface OrderFormMapper {
	void insertOrder(OrderForm orderForm);
	List<OrderForm>selectOrderByCustId(int custid);
	void deleteOrderFormById(int orderFormid);
}

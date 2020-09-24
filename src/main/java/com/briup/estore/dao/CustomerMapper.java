package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Customer;

public interface CustomerMapper {
	void insertCustomer(Customer customer);
	List<Customer> selectCustomerByName(String CustomerName);
}

package com.briup.estore.service;

import com.briup.estore.bean.Customer;

public interface ICustomerService {
	void register(Customer customer) throws Exception;
	Customer login(String name, String password) throws Exception;
}

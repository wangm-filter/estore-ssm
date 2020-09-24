package com.briup.estore.service.impl;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	
	@CacheEvict("{selectAddressesByCustId,selectAddressById}")
	@Override
	public void register(Customer customer) throws Exception {
		
		List<Customer> name = customerMapper.selectCustomerByName(customer.getName());
		if (name.size() > 0) {
			throw new Exception("该用户名已被使用，请重新输入!");
		}else {
			customerMapper.insertCustomer(customer);
			//session.commit();
		}
	}

	@Override
	public Customer login(String name,String passworsd) throws Exception {
		List<Customer> list = customerMapper.selectCustomerByName(name);
		Customer customer = null;
		if (list.size() > 0) {
			customer = list.get(0);
			if (customer.getPassword().equals(passworsd)) {
				return customer;
			}else {
				throw new Exception("密码错误,请重新输入!!");
			}
		}else {
			throw new Exception("用户名不存在,请重新输入!!");
		}
	}
}

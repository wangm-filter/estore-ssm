package com.briup.estore.web.controller;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangm
 */
@Controller
public class RegisterController{

	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/register")
	public String register(@RequestParam String name, @RequestParam String password,@RequestParam String zipCode,@RequestParam String telephone,@RequestParam String email){
		Customer customer = new Customer(name,password,zipCode,null,telephone,email);
		try {
			customerService.register(customer);
			return "login";
		} catch (Exception e) {
			e.getStackTrace();
			return "register";
		}
	}
}

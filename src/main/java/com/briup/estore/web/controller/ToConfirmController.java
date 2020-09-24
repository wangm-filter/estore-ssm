package com.briup.estore.web.controller;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.service.IShopAddressService;
import com.briup.estore.service.impl.ShopAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author wangm
 */
@Controller
public class ToConfirmController{
	@Autowired
	private IShopAddressService addressService;

	@RequestMapping("/user/toConfirm")
	public String toConfirm(HttpSession session){
		Customer customer = (Customer) session.getAttribute("customer");
		List<ShopAddress> addresslist = addressService.selectAddressesByCustId(customer.getId());
		session.setAttribute("addresslist", addresslist);

		return "user/confirm";
	}
}

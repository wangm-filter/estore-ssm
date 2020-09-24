package com.briup.estore.web.controller;

import com.briup.estore.bean.*;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.IShopAddressService;
import com.briup.estore.service.impl.OrderFormServiceImpl;
import com.briup.estore.service.impl.OrderLineServiceImpl;
import com.briup.estore.service.impl.ShopAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author wangm
 */
@Controller
public class ToOrderListController{
	@Autowired
	private IShopAddressService addressService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private  IOrderLineService lineService;

	@RequestMapping("/user/toOrderList")
	public String toOrderList(@RequestParam String shopAddId, HttpSession session){
		//根据id查询地址信息
		//从session中获取购物车信息
		ShopCar car = (ShopCar) session.getAttribute("shopCar");
		Customer customer = (Customer) session.getAttribute("customer");
		ShopAddress shopAddress = addressService.selectAddressById(Integer.parseInt(shopAddId));
		//保存订单
		OrderForm orderForm = new OrderForm();
		orderForm.setCost(car.getCost());
		orderForm.setCustomer(customer);
		orderForm.setOrderdate(new Date());
		orderForm.setShopAddress(shopAddress);
		//保存订单项
		orderFormService.inertOrderForm(orderForm);

		Map<Integer, OrderLine> map = car.getOrderLines();
		Set<Entry<Integer,OrderLine>> entrySet = map.entrySet();

		for (Entry<Integer, OrderLine> entry : entrySet) {
			OrderLine line = entry.getValue();
			line.setOrderForm(orderForm);
			lineService.insertLine(line);
		}
		//查询所有订单的信息
		List<OrderForm> orderlist = orderFormService.selectOrderByCustId(customer.getId());
		session.setAttribute("orderlist", orderlist);
		//跳转到orderList.jsp
		return "user/OrderList";
	}
}

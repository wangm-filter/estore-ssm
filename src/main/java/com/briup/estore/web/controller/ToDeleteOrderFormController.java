package com.briup.estore.web.controller;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.impl.OrderFormServiceImpl;
import com.briup.estore.service.impl.OrderLineServiceImpl;
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
import java.util.List;

/**
 * @author wangm
 */
@Controller
public class ToDeleteOrderFormController{
	@Autowired
	private IOrderLineService lineService;

	@Autowired
	private IOrderFormService formService;

	@RequestMapping("/user/toDeleteOrderForm")
	public String toDeleteOrderForm(@RequestParam String shopAddId,HttpSession session){
		lineService.deleteOrderLineByFromId(Integer.parseInt(shopAddId));
		formService.deleteFormById(Integer.parseInt(shopAddId));
		//设置弹框信息
		session.setAttribute("isDelete", "确认删除此订单吗？");
		return "forward:/user/deleteOrderFormById";
	}

	/**
	 * @author wanmg
	 * @param shopAddId
	 * @param session
	 * @return
	 */
	@RequestMapping("/user/deleteOrderFormById")
	public String deleteOrderFormById(String shopAddId,HttpSession session){
		formService.deleteFormById(Integer.parseInt(shopAddId));
		Customer customer = (Customer) session.getAttribute("customer");
		List<OrderForm> orderlist = formService.selectOrderByCustId(customer.getId());
		session.setAttribute("orderlist", orderlist);
		return "user/OrderList";
	}
}

package com.briup.estore.web.controller;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.service.IOrderLineService;
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
public class ToOrderDetailController{
	@Autowired
	private IOrderLineService lineService;

	@RequestMapping("/user/toOrderDetail")
	public  String toOrderDetail(@RequestParam String orderFormId,HttpSession session){
		List<OrderLine> linelist = lineService.selectLine(Integer.parseInt(orderFormId));
		session.setAttribute("linelist", linelist);
		int sumCost = 0;
		for (OrderLine orderLine : linelist) {
			sumCost += orderLine.getCost();
		}
		session.setAttribute("sumCost", sumCost);
		return "user/orderDetail";
	}
}

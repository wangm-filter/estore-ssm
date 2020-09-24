package com.briup.estore.web.filter;

import com.briup.estore.bean.Customer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			return true;
		}else {
			response.sendRedirect(request.getContextPath()+"/toLogin");
			//request.getRequestDispatcher("/toLogin").forward(request, response);
			return false;
		}
	}
}

package com.briup.estore.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;

public class AuthFilter implements Filter {

    public AuthFilter() {
    }
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			chain.doFilter(request, response);
		}else {
			req.getRequestDispatcher("/toLogin").forward(req, resp);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}

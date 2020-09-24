package com.briup.estore.web.controller;

import com.briup.estore.bean.Book;
import com.briup.estore.service.IBookservice;
import com.briup.estore.service.impl.BookServiceImpl;
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

/**
 * @author wangm
 */
@Controller
public class ViewBookController{
	@Autowired
	private IBookservice iBookservice;

	@RequestMapping("/viewBook")
	public String viewBook(@RequestParam String id, HttpSession session){
		//根据id查询书籍
		Book book = iBookservice.selectBookById(Integer.parseInt(id));
		//将查出的书籍保存到request中
		session.setAttribute("book", book);
		//跳转到viewbook.jsp页面
		return "viewBook";
	}
}

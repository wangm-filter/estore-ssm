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
import java.util.List;

/**
 * @author wangm
 */
@Controller
public class ToListController{

	@Autowired
	private IBookservice bookservice;

	@RequestMapping("/toList")
	public String toList(@RequestParam String id, HttpSession session){
		int cateId = Integer.parseInt(id);

		List<Book> booklist = bookservice.selectBookByCateId(cateId);
		session.setAttribute("booklist", booklist);

		List<Book> topBooklist = bookservice.selectBookByCateIdAndClick(cateId);
		session.setAttribute("topBooklist", topBooklist);
		return "list";
	}
}

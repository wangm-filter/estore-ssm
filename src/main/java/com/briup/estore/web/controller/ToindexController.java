package com.briup.estore.web.controller;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.service.IBookservice;
import com.briup.estore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * @author wangm
 */
@Controller
public class ToindexController{
	@Autowired
	private ICategoryService cateService;

	@Autowired
	private IBookservice bookservice;

	@RequestMapping("/toindex")
	public String toindex(HttpSession session){
		List<Category> categorylist = cateService.findFirstwithSecondCategory();
		session.setAttribute("categorylist", categorylist);

		List<Book> booklist = bookservice.finfBookById(1);
		session.setAttribute("booklist", booklist);

		List<Book> books = bookservice.seelctBooks();
		session.setAttribute("books", books);

		return "index";
	}
}

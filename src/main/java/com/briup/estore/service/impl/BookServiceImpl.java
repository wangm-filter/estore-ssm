package com.briup.estore.service.impl;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.service.IBookservice;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookservice {
	@Autowired
	private BookMapper bookMapper;
	
	@Cacheable(value = "finfBookById")
	@Override
	public List<Book> finfBookById(int id) {
		List<Book> booklist = bookMapper.selectBookByClick();

		return booklist;
	}
	
	@Cacheable(value = "selectBooks",key = "'books'")
	@Override
	public List<Book> seelctBooks() {
		List<Book> allbooks = bookMapper.selectBooks();
		return allbooks;
	}
	
	//@Cacheable(value = "selectBookById",key = "'selectBookById'")
	@Override
	public Book selectBookById(int id) {
		SqlSession session = null;
		Book book = bookMapper.selectBookById(id);
		int click = book.getClick();
		book.setClick(click + 1);
		
		return book;
	}
	
	@Cacheable(value = "selectBookByCateId",key="'selectBookByCateId'")
	@Override
	public List<Book> selectBookByCateId(int cateId) {
		List<Book> booklist = bookMapper.selectBookByCateId(cateId);
		
		return booklist;
	}
	
	@Cacheable(value = "selectBookByCateIdAndClick",key = "'selectBookByCateIdAndClick'")
	@Override
	public List<Book> selectBookByCateIdAndClick(int cateId) {
		List<Book> booklist = bookMapper.selectBookByCateIdAndClick(cateId);
		return booklist;
	}
}

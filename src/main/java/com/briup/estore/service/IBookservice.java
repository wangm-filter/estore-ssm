package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;

public interface IBookservice {
	List<Book> finfBookById(int id);
	List<Book> seelctBooks();
	Book selectBookById(int id);
	List<Book> selectBookByCateId(int cateId);
	List<Book> selectBookByCateIdAndClick(int cateId);
}

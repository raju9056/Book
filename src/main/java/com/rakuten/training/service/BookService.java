package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.domain.Book;

public interface BookService {
	
	int addNewBook(Book toBeAdded);
	void removeBook(int id);
	List<Book> findAll();
	Book findByid(int id);
	
	
	
	
	
	
	
}

package com.rakuten.training.dal;

import java.util.List;

import com.rakuten.training.domain.Book;

public interface BookDAO {
	//CRUD 
	Book save(Book toBeSaved);
	
	Book findById(int id);
	List<Book> findAll();
	void deleteByiD(int Id);
	
	
	
	
	
}

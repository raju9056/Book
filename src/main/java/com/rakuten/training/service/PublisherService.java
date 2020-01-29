package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.domain.Book;
import com.rakuten.training.domain.Publisher;


public interface PublisherService {

	int addPublisher(Publisher toBeAdded);
	public void removePublisher(int id);

	public List<Publisher> findAll();
		public Publisher findById(int id);
    
}

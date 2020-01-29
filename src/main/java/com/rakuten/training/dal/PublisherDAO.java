package com.rakuten.training.dal;

import java.util.List;

import com.rakuten.training.domain.Publisher;

public interface PublisherDAO {

	  Publisher findById(int id);

	  Publisher save(Publisher tobeAdded);

	  void deleteById(int id);

	  List<Publisher> findAll();
	  List<Publisher> findByBookId(int id);
}
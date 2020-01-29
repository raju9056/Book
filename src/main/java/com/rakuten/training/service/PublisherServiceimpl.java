package com.rakuten.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.PublisherDAO;
import com.rakuten.training.domain.Publisher;
@Transactional
@Service
public class PublisherServiceimpl implements PublisherService {

	PublisherDAO dao;
	
@Autowired
	public void setDao(PublisherDAO dao) {
		this.dao = dao;
	}


	@Override
	public int addPublisher(Publisher toBeAdded) {
		
		Publisher p = dao.save(toBeAdded);
		return p.getId();
	}

	@Override
	public void removePublisher(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Publisher> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Publisher findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}


	
}

package com.rakuten.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rakuten.training.dal.BookDAO;
import com.rakuten.training.dal.BookDAOinMemimpl;
import com.rakuten.training.service.BookService;
import com.rakuten.training.service.BookServiceimpl;
import com.rakuten.training.ui.BookConsoleUI;

//@Configuration
//@ComponentScan(basePackages="com.rakuten.training")
public class ProductAppConfiguration {
	
	
//	@Bean
//	public ProductDAO daoObj()
//	{
//		ProductDAOinMemimpl dao= new ProductDAOinMemimpl();
//		return dao;
//	}
//	
//	
//	@Bean
//	public ProductService serviceObj()
//	{
//		ProductServiceimpl service = new ProductServiceimpl();
//		service.setDao(daoObj());
//		return service;
//	}
//	@Bean
//	public ProductConsoleUI uiObj()
//	{
//		ProductConsoleUI ui = new ProductConsoleUI();
//		ui.setService(serviceObj());
//		return ui;
//	}
	
	
	
}

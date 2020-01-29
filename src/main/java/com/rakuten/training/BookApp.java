package com.rakuten.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.rakuten.training.ui.BookConsoleUI;
@SpringBootApplication
@Configuration
public class BookApp {

  public static void main(String[] args) {
	  //ApplicationContext springContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
	  ApplicationContext springContainer = 
			  SpringApplication.run(BookApp.class,args);
	  //BookConsoleUI ui= springContainer.getBean("uiObj",BookConsoleUI.class);
	  //ui.createBookWithUI();
		//ApplicationContext springContainer = 
		//SpringApplication.run(ProductAppApplication.class, args);
		BookConsoleUI ui = springContainer.getBean(BookConsoleUI.class);
//		ui.createBookWithUI();
    

  }
}

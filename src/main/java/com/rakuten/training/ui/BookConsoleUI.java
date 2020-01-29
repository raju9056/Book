package com.rakuten.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.training.domain.Book;
import com.rakuten.training.service.BookService;
import com.rakuten.training.service.BookServiceimpl;
@Component("uiObj")

public class BookConsoleUI {
	
	
  BookService service; // = new ProductServiceimpl();
  @Autowired
  public void setService(BookService service) {
    this.service = service;
  }

  public void createBookWithUI() {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter Book Name:");
    String name = s.nextLine();
    System.out.println("Enter Book Genre:");
    String genre = s.nextLine();
    System.out.println("Enter Number of Pages");
    int pages = Integer.parseInt(s.nextLine());
    System.out.println("Enter Price:");
    float price = Float.parseFloat(s.nextLine());

    Book p = new Book(name,genre,pages,price);
    int id = service.addNewBook(p);
    System.out.println("Created Product with id :" + id);
  }
}

package com.rakuten.training.ui;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Book;
import com.rakuten.training.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService service;
	
	
	@GetMapping("/book")
	public List<Book> getAllBook()
	{
		return service.findAll();
	}
	@GetMapping("/book/{prodid}")
	public ResponseEntity<Book> getBookById(@PathVariable("prodid")int id)
	{
		Book p = service.findByid(id);
		if(p  != null )
		{
			return new ResponseEntity<Book>(p,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Book>(p,HttpStatus.NOT_FOUND);
			
		}
		//return p;
		
	}
	
	
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book toBeAdded)
	{
		try {
			int id = service.addNewBook(toBeAdded);
			System.out.println("add_pROD"+id ); 
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/book/"+id));
			return new ResponseEntity<Book>(toBeAdded,headers,HttpStatus.CREATED);
			
		}
		catch(IllegalArgumentException e)
		{
			return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		}	
	}	
}

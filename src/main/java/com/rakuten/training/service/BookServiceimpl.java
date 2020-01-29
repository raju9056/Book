package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.BookDAO;
import com.rakuten.training.dal.BookDAOinMemimpl;
import com.rakuten.training.domain.Book;
@Service("serviceObj")
public class BookServiceimpl implements BookService {
	BookDAO dao;//= new ProductDAOinMemimpl();
	
	
@Autowired	
public void setDao(BookDAO dao) {
    this.dao = dao;
  }
	
	

  @Override
  public int addNewBook(Book toBeAdded) {
	  if( toBeAdded.getPages()>=1 )
		  
	  { 
		  if(toBeAdded.getGenre().equalsIgnoreCase("textbook") && toBeAdded.getPages()>1000)
	  {
		  System.out.println("Can not Add The Textbook" ); 
		  
		  throw new IllegalArgumentException("book has more page");
		  
	  }
		  else
		  {
			  Book added = dao.save(toBeAdded);
			  return added.getId();
			  
		  }
		  

	  }


	  else
	  {
		  System.out.println("Can not Add The Textbook" ); 
		  throw new IllegalArgumentException("The Textbook pages is >1000");
	  }

  }

//  @Override
//  public void removeProduct(int id) {
//	  Product existing = dao.findById(id);
//	  if(existing !=null)
//	  {
//		  if(existing.getPrice()*existing.getQoh()>=100000)
//		  {
//			  throw new IllegalStateException("Moneytory Value>1000.can't delete.");
//			  
//		  }
//		  else
//		  {
//			  dao.deleteByiD(id);
//		  }
//		  
//		  
//	  }
//
//    // TODO Auto-generated method stub
//    
//  }

  @Override
  public List<Book> findAll() {
    // TODO Auto-generated method stub
    return dao.findAll();
  }

  @Override
  public Book findByid(int id) {
    // TODO Auto-generated method stub
    return dao.findById(id);
  }



@Override public void removeBook(int id){// TODO Auto-generated method stub
}
	
}

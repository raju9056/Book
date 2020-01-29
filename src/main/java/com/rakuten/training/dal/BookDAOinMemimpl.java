package com.rakuten.training.dal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.rakuten.training.domain.Book;
//@Repository

public class BookDAOinMemimpl implements BookDAO 
{
	Map<Integer,Book> db= new ConcurrentHashMap<>();
	AtomicInteger idSequence = new AtomicInteger(0);
	
	

  public Book save(Book toBeSaved) {
    int id = idSequence.incrementAndGet();
    toBeSaved.setId(id);
    db.put(id, toBeSaved);
    return toBeSaved;
  }

  public Book findById(int id) {
    // TODO Auto-generated method stub
    return db.get(id);
  }

  public List<Book> findAll() {
    // TODO Auto-generated method stub
    return new ArrayList<>(db.values());
  }

  public void deleteByiD(int id) {
	  db.remove(id);
    // TODO Auto-generated method stub
    
  }
	
	
	
	
	
}

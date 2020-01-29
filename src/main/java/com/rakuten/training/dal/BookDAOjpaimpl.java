package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Book;


@Repository
@Transactional
public class BookDAOjpaimpl implements BookDAO {
	@Autowired
	//@Qualifier(value = "entityManager")
	EntityManager em;

  @Override
  public Book save(Book toBeSaved) {
	  em.persist(toBeSaved);
    // TODO Auto-generated method stub
    return toBeSaved;
  }

  @Override
  public Book findById(int id) {
	  Book p = em.find(Book.class,1);
	  //System.out.println("This Product has"+p.getReview().size()+"reviews" ); 
    // TODO Auto-generated method stub
    return em.find(Book.class, id);
  }

  @Override
  public List<Book> findAll() {
    // TODO Auto-generated method stub
	  Query q = em.createQuery("select p from book as p ");
	  List<Book> all = q.getResultList();
    return all;
  }

  @Override
  public void deleteByiD(int id) {
	  Book p = em.getReference(Book.class, id);
	  em.remove(p);
//	  Query q = em.createQuery("delete from Product as p where p.id=:idParam");
//	  q.setParameter("idParam", id);
//	  q.executeUpdate();
    
    
  }
	
	
	
	
}

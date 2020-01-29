package com.rakuten.training.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@javax.persistence.Entity
public class Publisher {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "publisher_id")
	int id ;
	@Column(name = "publisher_name")
	String name;
	@Column(name = "id")
	int book_id;
	
	@OneToMany
	@JoinColumn(name="id")
	List<Book> product;
	
	 public Publisher() {
    // TODO Auto-generated constructor stub
  }
	 
  public Publisher( String name, int book_id ) {
    super();
    this.name = name;
    this.book_id = book_id;

  }

  public int getId() {
  return id;}

  public void setId(int id) {
  this.id = id;}

  public String getName() {
  return name;}

  public void setName(String name) {
  this.name = name;}

  public int getBook_id() {
  return book_id;}

  public void setBook_id(int book_id) {
  this.book_id = book_id;}

  public List<Book> getProduct() {
  return product;}

  public  void setProduct(List<Book> product) {
  this.product = product;}


	
	
}

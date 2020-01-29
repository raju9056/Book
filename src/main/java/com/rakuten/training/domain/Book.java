package com.rakuten.training.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "name")
	String name ;
	@Column(name = "genre")
	String genre ;
	@Column(name = "pages")
	int pages;
	@Column(name = "price")
	float price;
	  @JsonIgnore
	  
//	  @OneToMany(fetch = FetchType.EAGER,mappedBy = "publisher_id",cascade = CascadeType.REMOVE)
	public Book() {
		

   
		}
  public Book(String name,String genre,int pages,float price) {
    super();
    this.name = name;
    this.genre= genre;
    this.pages=pages;
    this.price = price;
    
  }
public int getId() {
return id;}
public void setId(int id) {
this.id = id;}
public String getName() {
return name;}
public void setName(String name) {
this.name = name;}
public String getGenre() {
return genre;}
public void setGenre(String genre) {
this.genre = genre;}
public int getPages() {
return pages;}
public void setPages(int pages) {
this.pages = pages;}
public float getPrice() {
return price;}
public void setPrice(float price) {
this.price = price;}

	
}


package com.rakuten.training.web;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakuten.training.domain.Book;
import com.rakuten.training.service.BookService;
import com.rakuten.training.ui.BookController;

@RunWith(SpringRunner.class)
@WebMvcTest({BookController.class})
public class BookControlleUnitTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BookService service;
	
  @Test
  public void getBookById_Returns_OK_With_Correct_Book_If_Found() throws Exception {
    //Arrange
	  Book found = new Book("The Alchemist","Novel",210,330);
	  int id = 1;
	  found.setId(id);
	  Mockito.when(service.findByid(id)).thenReturn(found);
	//Act and Assert
	  mockMvc.perform(MockMvcRequestBuilders.get("/book/{id}",id))
	  		.andExpect(MockMvcResultMatchers.status().isOk())
	  		.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(id)));
	  
  }

  @Test
  public void addBook_Returns_CREATED_With_Valid_Product() throws Exception {
    // Arrange
    Book added = new Book("The Alchemist","Novel",210,330);
    int id = 1;
    added.setId(id);

    ObjectMapper mapper = new ObjectMapper();

    // Act & Assert
    Mockito.when(service.addNewBook(Mockito.any(Book.class))).thenReturn(id);
    
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(added)))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.header().string("location", "/book/"+ id));
    //Mockito.verify(service.addNewProduct(Mockito.any(Product.class)));
    Mockito.verify(service, Mockito.times(1)).addNewBook(Mockito.any(Book.class));
  }
  
  @Test
  public void delete_Product()
  {
	  Book found = new Book("The Alchemist","Novel",210,330);
	  int id = 1;
	  found.setId(id);
	  Mockito.when(service.findByid(id)).thenReturn(found);
	  Mockito.doThrow(IllegalStateException.class).when(service).removeBook(1);
	  Mockito.doNothing().when(service).removeBook(id);

	  
	  
  }
}
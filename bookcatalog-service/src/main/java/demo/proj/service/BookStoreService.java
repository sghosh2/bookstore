/**
 * 
 */
package demo.proj.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import demo.proj.dto.Book;
import demo.proj.dto.BookList;

/**
 * @author divija
 *
 */
 @Consumes("application/json")
 @Produces("application/json")
public interface BookStoreService {
     
	 @POST
	 @Path("/addbook")
	 public int addBook(Book book);
	 
	 @GET
	 @Path("/searchbook/{bookName}")
	 public BookList searchBook(@PathParam("bookName") String bookName);
	 
	 @GET
	 @Path("/popularbook/{bookName}")
	 public BookList getMostSoldBooks(@PathParam("bookName") String bookName);
	 
}

package demo.proj.service;

import java.io.IOException;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import demo.proj.dao.BookStoreDAO;
import demo.proj.dao.BookStoreDAOImpl;
import demo.proj.dto.Book;
import demo.proj.dto.BookList;

/*@Service
@Consumes("application/json")
@Produces("application/json")*/
public class BookStoreServiceImpl  implements BookStoreService {

	@Resource(name="bookDao")
	BookStoreDAO bookDao;
	
/*	public BookStoreServiceImpl() {
		System.out.println("loading BookStoreServiceImpl");
	}*/
	
/*	 @POST
	 @Path("/addbook")*/
	public int addBook(Book book) {
		return bookDao.addBook(book);
	}

	public BookList searchBook(String bookName) {
		// TODO Auto-generated method stub
		BookList bookLst = bookDao.searchBook(bookName);
		return bookLst;
	}

	public BookList getMostSoldBooks(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

/*	public BookStoreDAO getDao() {
		return bookDao;
	}

	public void setDao(BookStoreDAO dao) {
		this.bookDao = (BookStoreDAOImpl) dao;
	}*/

	
	/**
	 * testing serialization and deserialization using 
	 * JacksonJAXBAnnotations - FasterXML
	 * @param a
	 */
	public static void main(String [] a) {
		ObjectMapper mapper = new ObjectMapper();
		
		AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
		// if ONLY using JAXB annotations:
		mapper.setAnnotationIntrospector(introspector);
		
		// if using BOTH JAXB annotations AND Jackson annotations:
/*		AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
		mapper.setAnnotationIntrospector(new AnnotationIntrospectorPair(introspector, secondary));*/
		
		
		
/*		
    	// make deserializer use JAXB annotations (only)
	    mapper.getDeserializationConfig().withAppendedAnnotationIntrospector(introspector);
	    // make serializer use JAXB annotations (only)
	    mapper.getSerializationConfig().withAppendedAnnotationIntrospector(introspector);
	*/
		
		String bookstr = "{/\"book/\":{/\"name/\":/\"The truth/\",/\"author/\":/\"Sam/\",/\"count/\":/\"10/\"}}";
		
	   try {
		   
		   Book book = new Book();
		   book.setName("Truth");
		   book.setAuthor("Divija");
		   book.setCount(10);
		   Calendar pubdt = Calendar.getInstance();
		   pubdt.set(2015, Calendar.MAY, 1);
		   //book.setPublishDate(pubdt);
		   
		   String jsonData = mapper.writeValueAsString(book);
		   
		   System.out.println(jsonData);
		   
		   Book bookdes = mapper.readValue(jsonData, Book.class);
		
		  System.out.println(bookdes);
		
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    
	}
	
}

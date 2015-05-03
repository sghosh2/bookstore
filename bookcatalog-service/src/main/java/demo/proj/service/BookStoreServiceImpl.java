package demo.proj.service;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return bookDao.searchBook(bookName);
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

}

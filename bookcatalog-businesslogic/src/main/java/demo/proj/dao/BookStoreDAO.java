/**
 * 
 */
package demo.proj.dao;

import demo.proj.dto.Book;
import demo.proj.dto.BookList;

/**
 * @author sam
 *
 */
public interface BookStoreDAO {

	public int addBook(Book book);

	public BookList searchBook(String bookName);

	public BookList getMostSoldBooks(String bookName, int limit);
	
}

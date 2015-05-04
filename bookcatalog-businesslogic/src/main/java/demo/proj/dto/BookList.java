/**
 * 
 */
package demo.proj.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sam
 *
 */
@XmlRootElement(name="BookList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookList {

	List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
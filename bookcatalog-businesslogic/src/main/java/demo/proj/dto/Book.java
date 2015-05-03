/**
 * 
 */
package demo.proj.dto;

import java.util.Comparator;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sam
 * divija
 * divija
 */
@XmlRootElement(name="book")
public class Book implements Comparable<Book> {
	private String Name;
	private String Author;
	private int count;
	private int id;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return this.count - o.count;
	}
}
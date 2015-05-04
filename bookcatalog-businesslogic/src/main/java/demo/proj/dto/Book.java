/**
 * 
 */
package demo.proj.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import demo.proj.util.CalendarAdapter;

/**
 * @author sam
 * divija
 * divija
 */
@XmlRootElement(name="book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Comparable<Book>,Serializable {
	private String name;
	private String author;
	private int count;
	private int id;
/*	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(CalendarAdapter.class)
	private Calendar PublishDate;*/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		author = author;
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

/*	public Calendar getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(Calendar publishDate) {
		PublishDate = publishDate;
	}
*/
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return this.count - o.count;
	}
	
}
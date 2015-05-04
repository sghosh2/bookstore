package demo.proj.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.proj.dto.Book;
import demo.proj.dto.BookList;
import demo.proj.util.TernaryTree;

@Component("bookDao")
public class BookStoreDAOImpl implements BookStoreDAO {

	private AtomicInteger id;

//	/@Resource(name="ternaryTreeBook")
	@Resource(name="ternaryTree")
	private TernaryTree<Book> bookDB;
	
	@PostConstruct
	public void init() {
		System.out.println("init - post cons BookStoreDAOImpl");
		id = new AtomicInteger(1);
		//bookDB = new TernaryTree<Book>();
	}
	
	
	public int addBook(Book book) {
		book.setId(id.getAndIncrement());
		bookDB.add(book.getName(), book);
		return book.getId();
	}

	public BookList searchBook(String bookName) {
		PriorityQueue<Book> books = (PriorityQueue<Book>) bookDB.search(bookName);
		
		BookList booksList = new BookList();
		
		if(books != null) {
			List<Book> bookls = new ArrayList<Book>();
			booksList.setBooks(bookls);
			
			PriorityQueue<Book> booksCopy = new PriorityQueue<Book>(books);
			while(!booksCopy.isEmpty())
				bookls.add(booksCopy.poll());
			
		}
		
		return booksList;
	}

	public BookList getMostSoldBooks(String bookName, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] a) {
		BookStoreDAOImpl dao = new BookStoreDAOImpl();
		dao.init();
		dao.bookDB = new TernaryTree<Book>();
		dao.bookDB.init();
		Book b1 = new Book();
		b1.setName("Truth");
		b1.setAuthor("Divija");
		b1.setCount(10);
		
		Book b2 = new Book();
		b2.setName("Truth");
		b2.setAuthor("Sam");
		b2.setCount(5);
		
		Book b3 = new Book();
		b3.setName("Lie");
		b3.setAuthor("Ban");
		b3.setCount(5);
		
		Book b4 = new Book();
		b4.setName("Lamda");
		b4.setAuthor("Giant");
		b4.setCount(7);
		
		Book b5 = new Book();
		b5.setName("True story");
		b5.setAuthor("small");
		b5.setCount(8);
		
		Book b6 = new Book();
		b6.setName("Liliy");
		b6.setAuthor("medium");
		b6.setCount(3);
		
		dao.addBook(b1);
		dao.addBook(b2);
		dao.addBook(b3);
		dao.addBook(b4);
		dao.addBook(b5);
		dao.addBook(b6);
		
		BookList list = dao.searchBook("Tru");
         
		for(Book book: list.getBooks()) {
			System.out.println(String.format("Book Name: %s, count : %d, Author: %s", book.getName(), book.getCount(), book.getAuthor()));
		}
		
		System.out.println("Second run search term L");
		list = dao.searchBook("L");
        
		for(Book book: list.getBooks()) {
			System.out.println(String.format("Book Name: %s, count : %d, Author: %s", book.getName(), book.getCount(), book.getAuthor()));
		}

	}
	
}

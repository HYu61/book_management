package pers.hyu.bookmanagement.service.implement;

import java.util.ArrayList;
import java.util.List;

import pers.hyu.bookmanagement.entity.Book;
import pers.hyu.bookmanagement.service.BookService;

public class BookServiceImpl implements BookService {
	private static final List<Book> books = new ArrayList<Book>();
	
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBook(String bookId) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * 根据bookId查询book，返回查到的book或无结果返回null
	 */
	@Override
	public Book getBooksByBookId(String bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据图书类别查询图书，返回查询到的该类别下的所有图书，如没有返回null
	 */
	@Override
	public List<Book> getBooksByCategoryName(String catgoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

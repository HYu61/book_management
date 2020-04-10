package pers.hyu.bookmanagement.service.implement;

import java.util.ArrayList;
import java.util.List;

import pers.hyu.bookmanagement.entity.Book;
import pers.hyu.bookmanagement.service.BookService;

public class BookServiceImpl implements BookService {
	private static final List<Book> books = new ArrayList<Book>();
	
	
	public static List<Book> getBooks() {
		return books;
	}

	/**
	 * 添加书籍到图书列表中
	 */
	@Override
	public void addBook(Book book) {	
			books.add(book);	
	}

	/**
	 * 更新图书
	 */
	@Override
	public void updateBook(Book replaceBook) {
		// 找到要更新的图书
		Book updatebook =  getBookByBookId(replaceBook.getBookId());
		
		//更新图书信息 -- 除了bookId
		updatebook.setBookName(replaceBook.getBookName());
		updatebook.setBookCategory(replaceBook.getBookCategory());
		updatebook.setBookPrice(replaceBook.getBookPrice());
		updatebook.setBookImagePath(replaceBook.getBookImagePath());
		updatebook.setBookRemark(replaceBook.getBookRemark());

	}

	/**
	 * 根据图书Id 删除图书
	 */
	@Override
	public void deleteBook(String bookId) {
		// TODO Auto-generated method stub
		Book deleteBook = getBookByBookId(bookId);
		if(deleteBook != null) {
			books.remove(deleteBook);
		}

	}

	
	/**
	 * 根据bookId查询book，返回查到的book或无结果返回null
	 */
	@Override
	public Book getBookByBookId(String bookId) {
		// TODO Auto-generated method stub
		Book book = null;
		for(Book b : books) {
			if(bookId.equalsIgnoreCase(b.getBookId())) {
				book = b;
				break;
			}
		}
		return book;
	}

	/**
	 * 根据图书类别查询图书，返回查询到的该类别下的所有图书，如没有返回空list
	 */
	@SuppressWarnings("null")
	@Override
	public List<Book> getBooksByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		List<Book> bookListByCate = new ArrayList<Book>();
		if(categoryName != null && books.size() > 0) {
			for(Book b : books) {
				if(categoryName.equalsIgnoreCase(b.getBookCategory())) {
					bookListByCate.add(b);
				}
			}
		}		
		return bookListByCate;
	}

}

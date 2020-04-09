package pers.hyu.bookmanagement.service;

import java.util.List;
import pers.hyu.bookmanagement.entity.Book;

/**
 * 图书管理接口
 * @author hyu
 *
 */
public interface BookService {
	
	/**
	 * 添加图书
	 * @param book 要添加的图书
	 */
	public void addBook(Book book);

	/**
	 * 更新图书信息
	 * @param bookId 要更新的图书Id
	 * @param book 要更新的图书
	 */
	public void updateBook(String bookId, Book book);

	/**
	 * 根据图书id删除书籍
	 * @param bookId 要删除的图书id
	 */
	public void deleteBook(String bookId);

	/**
	 * 根据图书id查询书籍
	 * @param bookId 要查询的图书id
	 * @return 查询到的图书
	 */
	public Book getBookByBookId(String bookId);

	/**
	 * 根据图书类别查询图书
	 * @param catgoryName 要查询的图书类别名称
	 * @return 查询到的该类别下的所有图书
	 */
	public List<Book> getBooksByCategoryName(String catgoryName);

}

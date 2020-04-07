package pers.hyu.bookmanagement.entity;

import java.io.Serializable;

/**
 * book类
 * @author hyu
 *
 */
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//book 的id，书名，分类，价格，封面存放路径，备注
	private String bookId;
	private String bookName;
	private String bookCategory;
	private Float bookPrice;
	private String bookImagePath;
	private String bookRemark;
	
	//无参构造
	public Book() {
		super();
	}

	/**
	 * book代参构造
	 * @param bookId 图书id
	 * @param bookName 书名
	 * @param bookCategory 书籍分类
	 * @param bookPrice 价格
	 * @param bookImagePath 封面图片存放路径
	 * @param bookRemark 备注信息
	 */
	public Book(String bookId, String bookName, String bookCategory, Float bookPrice, String bookImagePath,
			String bookRemark) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookCategory = bookCategory;
		this.bookPrice = bookPrice;
		this.bookImagePath = bookImagePath;
		this.bookRemark = bookRemark;
	}

	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public Float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookImagePath() {
		return bookImagePath;
	}

	public void setBookImagePath(String bookImagePath) {
		this.bookImagePath = bookImagePath;
	}

	public String getBookRemark() {
		return bookRemark;
	}

	public void setBookRemark(String bookRemark) {
		this.bookRemark = bookRemark;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookCategory=" + bookCategory + ", bookPrice="
				+ bookPrice + ", bookImagePath=" + bookImagePath + ", bookRemark=" + bookRemark + "]";
	}
	

}

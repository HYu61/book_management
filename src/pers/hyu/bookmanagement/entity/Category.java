package pers.hyu.bookmanagement.entity;

import java.io.Serializable;

/**
 * Category类
 * 
 * @author hyu
 *
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	// 分类id 和 名称
	private String categoryId;
	private String categoryName;

	// 无参构造
	public Category() {

	}

	/**
	 * 代参构造
	 * 
	 * @param categoryId   分类id
	 * @param categoryName 分类名称
	 */
	public Category(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}

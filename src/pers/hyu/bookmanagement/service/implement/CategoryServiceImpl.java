package pers.hyu.bookmanagement.service.implement;

import java.util.ArrayList;
import java.util.List;
import pers.hyu.bookmanagement.entity.Category;
import pers.hyu.bookmanagement.service.CategoryService;

/**
 * Category实现类
 * 
 * @author hyu
 *
 */
public class CategoryServiceImpl implements CategoryService {

	private static final List<Category> categoryDb = new ArrayList<Category>();

	// 获取categoryDb
	public static List<Category> getCategorydb() {
		return categoryDb;
	}

	/**
	 * 增加图书分类
	 */
	@Override
	public void addCategory(String categoryId, String categoryName) {
		categoryDb.add(new Category(categoryId, categoryName));
	}

	/**
	 * 删除分类
	 */
	@Override
	public void deleteCategory(String categoryId) {
		// 获取cate的index
		int deleteIndex = searchCategory(categoryId);
		if (deleteIndex != -1) {
			categoryDb.remove(this.searchCategory(categoryId));
		}
	}

	/**
	 * 查询分类列表中是否存在该id或name (id和name都是唯一性)
	 * 
	 * @param categoryId   要查找的分类id
	 * @param categoryName 要查找的分类名字
	 * @return 0为存在， -1为不存在 （无需获取index）
	 */
	public int searchCategory(String categoryId, String categoryName) {

		int result = -1;
		if (!categoryDb.isEmpty()) {
			for (Category c : categoryDb) {
				if (categoryId.equals(c.getCategoryId()) || categoryName.equalsIgnoreCase(c.getCategoryName())) {
					result = 0;
					System.out.println(result);
					break;
				}
			}
		}

		return result;
	}

	/**
	 * 查询该分类是否存在categoryDb中
	 * 
	 * @param categoryId 要查询的分类Id
	 * @return 该分类在分类列表中的index； -1表示不存在
	 */
	public int searchCategory(String categoryId) {
		int result = -1;
		if (!categoryDb.isEmpty()) {
			for (Category c : categoryDb) {
				if (categoryId.equals(c.getCategoryId())) {
					// 获取cate所在list的index
					result = categoryDb.indexOf(c);
					break;
				}
			}
		}

		return result;
	}

}

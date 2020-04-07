package pers.hyu.bookmanagement.service;

/**
 * 图书分类管理接口
 * @author hyu
 *
 */
public interface CategoryService {
	
	/**
	 * 添加图书分类
	 * @param categoryId 分类id
	 * @param catgoryName 分类名称
	 */
	public void addCategory(String categoryId, String categoryName);

	/**
	 * 根据分类id删除图书分类
	 * @param categoryId 分类id
	 */
	public void deleteCategory(String categoryId);

}

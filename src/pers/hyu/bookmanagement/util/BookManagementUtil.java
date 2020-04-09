package pers.hyu.bookmanagement.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import pers.hyu.bookmanagement.entity.Book;
import pers.hyu.bookmanagement.service.implement.CategoryServiceImpl;

/**
 * 上传文件重命名
 * 
 * @author hyu
 *
 */
public class BookManagementUtil {

	/**
	 * 按照指定格式重命名
	 * 
	 * @param bookId   图书的id号
	 * @param fileName 原始文件名
	 * @return 新文件名 eg： book0001-image.jpg
	 */
	public static String fileRename(String bookId, String fileName) {
		String newFileName = "";
		if (bookId != null && fileName != null) {
			int index = fileName.lastIndexOf('.');
			if (index != -1) {
				//获得文件扩张名
				String fileExten = fileName.substring(index);
				//新文件名
				newFileName = bookId + "-image" + fileExten;
			}else {
				newFileName = bookId;
			}
		}
		return newFileName;

	}
	
	/**
	 * 根据表单内容创建书籍
	 * @param req 表单提交的request
	 * @return 根据表单内容创建好的书籍
	 */
	public static Book generateBook(HttpServletRequest req ) {
		//获取图书信息
		String bookId;
		String bookName;
		String bookCategory;
		Float bookPrice;
		String bookImagePath;
		String bookRemark;
		
		Map<String, String> bookInfoMap = new HashMap<String, String>();	
		ServletFileUpload servleFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> fileItemList = servleFileUpload.parseRequest(req);
			for(FileItem fileItem : fileItemList) {
				if(fileItem.isFormField()) {
					//除封面外所有书籍信息存在map里
					bookInfoMap.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
					
				}else {
					//图片存到bookImages文件夹中并重命名
					String fileName = BookManagementUtil.fileRename(bookInfoMap.get("bookId"), fileItem.getName());
					String bookImageRealPath = req.getServletContext().getRealPath("/bookImages") + "/" + fileName;
					fileItem.write(new File(bookImageRealPath));
					bookInfoMap.put("bookImagePath", req.getContextPath() + "/bookImages/" + fileName );
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//根据categoryId 值查找categoryName
		CategoryServiceImpl csi = new CategoryServiceImpl();
		int cateIndex = csi.searchCategory(bookInfoMap.get("categoryId"));
		if(cateIndex != -1) {
			bookCategory = CategoryServiceImpl.getCategorydb().get(cateIndex).getCategoryName();
		}else {
			bookCategory = " ";
		}
		
		bookId = bookInfoMap.get("bookId");
		bookName = bookInfoMap.get("bookName");		
		bookPrice = Float.parseFloat(bookInfoMap.get("bookPrice")); 
		bookImagePath = bookInfoMap.get("bookImagePath");
		bookRemark = bookInfoMap.get("remarks");
		
		//根据表单内容创建书籍
		Book book = new Book(bookId, bookName, bookCategory, bookPrice, bookImagePath, bookRemark);
		
		return book;
		
	}

}

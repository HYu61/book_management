package pers.hyu.bookmanagement.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import pers.hyu.bookmanagement.entity.Book;
import pers.hyu.bookmanagement.service.implement.BookServiceImpl;
import pers.hyu.bookmanagement.service.implement.CategoryServiceImpl;
import pers.hyu.bookmanagement.util.FileUploadUtil;

/**
 * 添加bookservlet
 * @author hyu
 *
 */
public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取图书信息
		String bookId;
		String bookName;
		String bookCategory;
		Float bookPrice;
		String bookImagePath;
		String bookRemark;
		
		Map<String, String> bookMap = new HashMap<String, String>();	
		ServletFileUpload servleFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> fileItemList = servleFileUpload.parseRequest(req);
			for(FileItem fileItem : fileItemList) {
				if(fileItem.isFormField()) {
					//除封面外所有书籍信息存在map里
					bookMap.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
					
				}else {
					//图片存到bookImages文件夹中并重命名
					String fileName = FileUploadUtil.fileRename(bookMap.get("bookId"), fileItem.getName());
					String bookImageRealPath = getServletContext().getRealPath("/bookImages") + "/" + fileName;
					fileItem.write(new File(bookImageRealPath));
					bookMap.put("bookImagePath", req.getContextPath() + "/bookImages/" + fileName );
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
		int cateIndex = csi.searchCategory(bookMap.get("categoryId"));
		if(cateIndex != -1) {
			bookCategory = CategoryServiceImpl.getCategorydb().get(cateIndex).getCategoryName();
		}else {
			bookCategory = " ";
		}
		
		bookId = bookMap.get("bookId");
		bookName = bookMap.get("bookName");		
		bookPrice = Float.parseFloat(bookMap.get("bookPrice")); 
		bookImagePath = bookMap.get("bookImagePath");
		bookRemark = bookMap.get("remarks");
		
		//增加书籍
		Book book = new Book(bookId, bookName, bookCategory, bookPrice, bookImagePath, bookRemark);
		
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		//如果书籍id存在，不添加
		if(bookServiceImpl.getBooksByBookId(bookId) == null) {
			bookServiceImpl.addBook(book);
		}else {
			req.setAttribute("msg", "图书id: \""+ bookId +"\" 已存在，无法添加！");
		}
	
		//返回bookList页面
		req.getServletContext().setAttribute("bookList", BookServiceImpl.getBooks());
		req.getRequestDispatcher(req.getContextPath()+"/admin/bookList.jsp").forward(req, resp);
		//resp.sendRedirect(req.getContextPath()+"/admin/bookList.jsp");
		
	}
	
	

}

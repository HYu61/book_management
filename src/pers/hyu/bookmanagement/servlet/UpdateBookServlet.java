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

public class UpdateBookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取要修改的bookId, 并转到修改图书页面
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String updateBookId = req.getParameter("bookId");
		Book updateBook = new BookServiceImpl().getBookByBookId(updateBookId);
		req.setAttribute("updateBook", updateBook);
		req.getRequestDispatcher(req.getContextPath()+"/admin/updateBook.jsp").forward(req, resp);
	}

	/**
	 * 根据修改信息，修改图书
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//new BookServiceImpl().updateBook(bookId, book);
	
		Book updatedBook = new FileUploadUtil().generateBook(req);	
		
		
		resp.getWriter().println("sdfdsfd");
	}
	
	

}

package pers.hyu.bookmanagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.hyu.bookmanagement.service.implement.BookServiceImpl;

public class DeleteBookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获得bookid
		String deleteBookId = req.getParameter("bookId");
		//删除图书
		new BookServiceImpl().deleteBook(deleteBookId);
		//返回bookList页面
		resp.sendRedirect(req.getContextPath() + "/admin/bookList.jsp");
		
		
	}
	
	

}

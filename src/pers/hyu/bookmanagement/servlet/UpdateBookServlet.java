package pers.hyu.bookmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pers.hyu.bookmanagement.entity.Book;
import pers.hyu.bookmanagement.service.implement.BookServiceImpl;
import pers.hyu.bookmanagement.util.BookManagementUtil;

public class UpdateBookServlet extends HttpServlet {

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

		//根据修改信息，创建图书
		Book updatedBook = BookManagementUtil.generateBook(req);
		
		//修改图书
		new BookServiceImpl().updateBook(updatedBook);
		
		//返回图书列表页
		resp.sendRedirect(req.getContextPath() + "/admin/bookList.jsp");
		
	}
	
	

}

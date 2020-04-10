package pers.hyu.bookmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pers.hyu.bookmanagement.entity.Book;
import pers.hyu.bookmanagement.service.implement.BookServiceImpl;
import pers.hyu.bookmanagement.util.BookManagementUtil;

/**
 * 添加bookservlet
 * @author hyu
 *
 */
public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//根据表单内容获得的书籍
		Book newBook = BookManagementUtil.generateBook(req);
		
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		//如果书籍id存在，不添加
		if(bookServiceImpl.getBookByBookId(newBook.getBookId()) == null) {
			bookServiceImpl.addBook(newBook);
		}else {
			req.setAttribute("msg", "图书id: \""+ newBook.getBookId() +"\" 已存在，无法添加！");
		}
	
		//返回bookList页面
		//req.getServletContext().setAttribute("bookList", BookServiceImpl.getBooks());
		req.getRequestDispatcher(req.getContextPath()+"/admin/bookList.jsp").forward(req, resp);
		//resp.sendRedirect(req.getContextPath()+"/admin/bookList.jsp");
		
	}
	
	

}

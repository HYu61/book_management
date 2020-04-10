package pers.hyu.bookmanagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import pers.hyu.bookmanagement.entity.Book;
import pers.hyu.bookmanagement.service.implement.BookServiceImpl;

public class SearchBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get cate name from form
		String categoryName = req.getParameter("searchContent");
		
		//get booklist if the catename id vaild
		
		List<Book> searchedBooksList = new BookServiceImpl().getBooksByCategoryName(categoryName);

		//send bookList to browser
		String searchedBooksJson = new ObjectMapper().writeValueAsString(searchedBooksList);
		resp.getWriter().print(searchedBooksJson);
	}
	
	

}

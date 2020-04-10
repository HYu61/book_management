package pers.hyu.bookmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pers.hyu.bookmanagement.service.implement.CategoryServiceImpl;

/**
 * 删除分类
 * @author hyu
 *
 */
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取要删除的cateId from param
		String deleteCategoryId = request.getParameter("categoryId");
		
		//删除cate 
		CategoryServiceImpl categoryService = new CategoryServiceImpl();		
		categoryService.deleteCategory(deleteCategoryId);
		
		//返回显示页面
		//request.getRequestDispatcher(request.getContextPath() + "/admin/categoryList.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/admin/categoryList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package pers.hyu.bookmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pers.hyu.bookmanagement.service.implement.CategoryServiceImpl;

/**
 * 添加图书分类
 * @author hyu
 *
 */
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得分类id和名字
		String categoryId = request.getParameter("categoryId");
		String categoryName = request.getParameter("categoryName");
		
		
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		
		//判断id或name是否存在， 都不存在时添加到分类list中，有一个存在就返回提示信息
		if(categoryService.searchCategory(categoryId, categoryName) == -1) {
			categoryService.addCategory(categoryId, categoryName);
		}else {
			request.setAttribute("msg", "分类编号： \""+ categoryId + "\" 或分类名称： \"" + categoryName + "\" 已存在。请检查！");
		}
				
		//把categoryList存到Servlet中并返回到分类显示页
		request.getServletContext().setAttribute("categoryList", CategoryServiceImpl.getCategorydb());
		request.getRequestDispatcher(request.getContextPath() + "/admin/categoryList.jsp").forward(request, response);
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	
	
}

package pers.hyu.bookmanagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.hyu.bookmanagement.entity.User;
import pers.hyu.bookmanagement.service.UserService;
import pers.hyu.bookmanagement.service.implement.UserServiceImpl;

/**
 * login servlet
 * 
 * @author hyu
 *
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg", "请点击下面的登陆按钮重新登陆");
		request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 验证验证码
		String code = request.getSession().getAttribute("verifyCode").toString();
		String toBeVerifyedCode = request.getParameter("verifyCode");
		if (toBeVerifyedCode == null || !toBeVerifyedCode.equalsIgnoreCase(code)) {
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
			return;
		}

		// 获得用户名和密码
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		// 验证用户名和密码
		@SuppressWarnings("unchecked")
		// 获取用户列表
		List<User> userList = (List<User>) request.getServletContext().getAttribute("userList");

		// 查看登陆用户是否存在
		UserService userService = new UserServiceImpl();
		int userIndex = userService.login(userList, new User(userName, password));
		// 用户存在
		if (userIndex != -1) {
			request.getSession().setAttribute("user", userList.get(userIndex));
			response.sendRedirect(request.getContextPath() + "/pages/categoryList.jsp");
			// 用户不存在
		} else {
			request.setAttribute("msg", "用户名或密码无效");
			request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
		}
	}

}

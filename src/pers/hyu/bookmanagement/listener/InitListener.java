package pers.hyu.bookmanagement.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import pers.hyu.bookmanagement.entity.User;
import pers.hyu.bookmanagement.service.implement.BookServiceImpl;
import pers.hyu.bookmanagement.service.implement.CategoryServiceImpl;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */

public class InitListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public InitListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 删除登陆用户组
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("userList", null);
	}

	/**
	 * 创建默认登陆用户组
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// 创建登陆用户并保存到用户列表中
		User user_1 = new User("admin", "admin");
		User user_2 = new User("hyu", "123456");

		List<User> userList = new ArrayList<User>();
		userList.add(user_1);
		userList.add(user_2);

		// 把userList存到servletContext中
		sce.getServletContext().setAttribute("userList", userList);
		sce.getServletContext().setAttribute("categoryList", CategoryServiceImpl.getCategorydb());
		sce.getServletContext().setAttribute("bookList", BookServiceImpl.getBooks());
	}

}

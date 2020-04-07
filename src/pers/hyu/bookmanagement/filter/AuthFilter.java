package pers.hyu.bookmanagement.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 判断用户是否登录的过滤器
 * 
 * @author hyu
 *
 */

public class AuthFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hSRequest = (HttpServletRequest) request;
		HttpServletResponse hSResponse = (HttpServletResponse) response;

		// 放行验证码servlet 和 login servlet
		if (hSRequest.getRequestURI().endsWith("verifyCode") || hSRequest.getRequestURI().endsWith("login") ) {
			chain.doFilter(request, response);
			return;
		}
		// 判断用户是否登陆
		if (hSRequest.getSession().getAttribute("user") == null) {
			hSRequest.setAttribute("msg", "请先登陆");
			hSRequest.getRequestDispatcher(hSRequest.getContextPath() + "/login.jsp").forward(hSRequest, hSResponse);
			// hSResponse.sendRedirect(hSRequest.getContextPath() + "/login.jsp");
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

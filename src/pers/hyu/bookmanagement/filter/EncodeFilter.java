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
 * 编码filter
 * 
 * @author hyu
 *
 */
public class EncodeFilter implements Filter {

	// 编码格式
	private String encode;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hSRequest = (HttpServletRequest) request;
		HttpServletResponse hSResponse = (HttpServletResponse) response;
		
		//放行验证码servlet
		if (hSRequest.getRequestURI().endsWith("verifycode")) {
			chain.doFilter(request, response);
			return;
		}
		// 设置encoding
		hSRequest.setCharacterEncoding(this.encode);
		hSResponse.setContentType("text/html;charset=" + this.encode);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 从xml配置中获取编码格式
		this.encode = filterConfig.getInitParameter("encode");

	}

}

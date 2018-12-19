package learning.java.spring.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(urlPatterns = "/info", filterName="loginFilter")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Login Filter destroy!");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)rsp;
		// 查询数据库核对用户名和密码
		String uesrname = request.getParameter("uesrname");
		String password = request.getParameter("password");
		System.out.println("Login Filter doFilter!");
		if (filterAccount(uesrname, password)) {
			fc.doFilter(request, response);
		}else {
			response.sendRedirect("/index.html");
		}
	}
	
	public boolean filterAccount(String userName, String passWord) {
		// TODO:过滤账号信息
		return true;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Login Filter initial!");
	}

}

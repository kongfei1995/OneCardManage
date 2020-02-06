package com.cardsys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//控制用户访问权限
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session=req.getSession();

		if ("/logout.html".equals(req.getServletPath())) {
			session.removeAttribute("user");
			res.sendRedirect(req.getContextPath()+"/login.jsp");
		} else if(session.getAttribute("user")!= null || "/login.html".equals(req.getServletPath())
				 || "/user/save.html".equals(req.getServletPath()) || "/code.html".equals(req.getServletPath())){
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(req.getContextPath()+"/error.jsp");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	

	}
}
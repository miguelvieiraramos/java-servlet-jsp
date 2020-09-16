package br.miguel;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/index.jsp", "/welcome.jsp"})
public class LoginFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		
		boolean isLoggedIn = (session.getAttribute("name") != null);
		String loginURI = httpServletRequest.getContextPath() + "/index.jsp";
		boolean isLoginPage = httpServletRequest.getRequestURI().equals(loginURI);
		
		if(isLoggedIn && isLoginPage) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
            dispatcher.forward(request, response);
		} else if(isLoggedIn) {
			httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidade");
			chain.doFilter(request, httpServletResponse);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
		}
	}
}

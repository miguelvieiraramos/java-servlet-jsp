package br.unisul;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/filter-servlet")
public class Filter implements javax.servlet.Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		int numero = Integer.parseInt(httpServletRequest.getParameter("numero"));
		if(numero < 5) {
			response.getWriter().print("Número é menor que 5");
		} else {
			chain.doFilter(request, response);
		}
	}

}

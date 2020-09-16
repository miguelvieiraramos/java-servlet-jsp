package br.unisul;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ServletConfigContext", urlPatterns = "/ServletConfigContext")
public class ServletConfigContext extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Pega init params globais
		ServletContext servletContext = request.getServletContext();
		
		//Pega init params exclusivos deste servlet
		ServletConfig servletConfig = getServletConfig();

		response.getWriter().print(
				"Hello " + servletContext.getInitParameter("name") + "<br> Hello " + servletConfig.getInitParameter("name"));
		
	}
}

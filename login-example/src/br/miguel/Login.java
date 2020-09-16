package br.miguel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="Login", urlPatterns = "/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(name.equals("miguel") && password.equals("senha")) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			response.sendRedirect("./welcome.jsp");
		} else {
			response.sendRedirect("./index.jsp");
		}
	}
}

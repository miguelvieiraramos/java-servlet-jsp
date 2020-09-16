package br.unisul;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Foo", urlPatterns = "/foo")
public class Foo extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.getWriter().println("Hello");
			HttpSession session = req.getSession();
			session.setAttribute("name", "Abajur Amarelo");
			
			Cookie cookie = new Cookie("nome", "Miguel");
			res.addCookie(cookie);
			res.sendRedirect("abajur");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

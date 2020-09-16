package br.unisul;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "abajur", urlPatterns = "/abajur")
public class Abajur extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			HttpSession session = req.getSession();
			String name = (String) session.getAttribute("name");
			
			Cookie[] cookies = req.getCookies();
			String nome = "";
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("nome")) {
					nome = cookie.getValue();
				}
			}
			
			res.getWriter().println(name + "\n" + nome);
//			session.removeAttribute("name");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

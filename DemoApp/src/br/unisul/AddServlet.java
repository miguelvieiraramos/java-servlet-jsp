package br.unisul;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int firstNumber = Integer.parseInt(req.getParameter("firstNumber"));
		int secondNumber = Integer.parseInt(req.getParameter("secondNumber"));
		int sum = firstNumber + secondNumber;
//		try {
//			res.getWriter().println("O resultado é: " + sum);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		req.setAttribute("sum", sum);
		RequestDispatcher rd = req.getRequestDispatcher("square");
		rd.forward(req, res);
	}
}

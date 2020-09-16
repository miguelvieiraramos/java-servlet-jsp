package br.unisul;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SquareServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int sum = (int) req.getAttribute("sum");
		int square = sum * sum;
		res.getWriter().println("Resultado é " + square);
	}
}

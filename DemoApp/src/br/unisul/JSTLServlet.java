package br.unisul;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="JSTLServlet", urlPatterns = "/jstl-servlet")
public class JSTLServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa pessoa = new Pessoa("Luciana", "Ramos");
		request.setAttribute("pessoa", pessoa);
		
		request.setAttribute("nome", "Miguel Ramos");
		
		List<Pessoa> pessoas = Arrays.asList(new Pessoa("Murilo", "Ramos"), new Pessoa("Raiana", "Dalla Porta"));
		request.setAttribute("pessoas", pessoas);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./jstl.jsp");
		requestDispatcher.forward(request, response);
	}
}

package presentation.controllers.user.loadUsers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import data.protocols.db.user.LoadUsersRepository;
import data.usecases.user.addUser.DbLoadUsers;
import domain.models.User;
import domain.usecases.user.LoadUsers;
import infra.user.UserPostgresRepository;

@WebServlet(name="LoadUsersController", urlPatterns="/")
public class LoadUsersController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./main.jsp");
		LoadUsersRepository loadUsersRepository = new UserPostgresRepository();
		LoadUsers loadUsers	= new DbLoadUsers(loadUsersRepository);
		List<User> users = loadUsers.load();
		request.setAttribute("users", users);
		requestDispatcher.forward(request, response);
	}
}

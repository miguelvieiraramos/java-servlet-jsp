package presentation.controllers.user.addUser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.protocols.db.user.AddUserRepository;
import data.protocols.db.user.LoadUserByNameAndLastNameRepository;
import data.usecases.user.addUser.DbAddUser;
import domain.models.User;
import infra.user.UserPostgresRepository;
import validation.validators.UserValidation;

@WebServlet(name="AddUserController", urlPatterns = "/add-user")
public class AddUserController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		
		boolean isValid = new UserValidation().validate(name, lastName);
		if(!isValid) {
			request.setAttribute("error", "Os campos estão mal formatados!");
			requestDispatcher = request.getRequestDispatcher("./index.jsp");
			requestDispatcher.forward(request, response);
		}
		AddUserRepository addUserRepository = new UserPostgresRepository();
		LoadUserByNameAndLastNameRepository loadUserByNameAndLastNameRepository = new UserPostgresRepository();
		User user = new DbAddUser(addUserRepository, loadUserByNameAndLastNameRepository).add(name, lastName);;
		response.sendRedirect(request.getContextPath());
	}
}

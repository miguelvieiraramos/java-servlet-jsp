import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AddUserController", urlPatterns="/add-user")
public class AddUserController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse resposne) throws IOException, ServletException {
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DataService.getConnPostgres();
			preparedStatement = conn.prepareStatement("INSERT INTO public.\"user\"(name, last_name) VALUES (?, ?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, lastName);
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

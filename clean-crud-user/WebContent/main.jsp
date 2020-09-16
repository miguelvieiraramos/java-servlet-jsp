<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, domain.models.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String error = (String) request.getAttribute("error");
		if(error != null) {
			out.print(error);
		}
		request.removeAttribute("error");
	%>
	<h1>Add User</h1>
	<form action="add-user" method="post">
		<input type="text" name="name" placeholder="Name"><br>
		<input type="text" name="lastName" placeholder="Last Name"><br>
		<input type="submit" value="Add"><br>
	</form>
	<br>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Sobrenome</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<User> users = (List<User>) request.getAttribute("users");
				for(User user : users) {
					out.print("<tr><td>" + user.getName() + "<td>\n" +
							  "<td>" + user.getLastName() + "<td></tr>");
				}
			%>
		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, domain.models.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
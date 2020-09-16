<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- pegando o atributo do request -->
	${nome}<br />
	${pessoa.nome}<br>
	<c:out value="Hello World" /> <br>
	<h1>Lista de Pessoas</h1>
	<c:forEach items="${pessoas}" var="pessoa">
		${pessoa.nome}<br>
	</c:forEach>
</body>
</html>
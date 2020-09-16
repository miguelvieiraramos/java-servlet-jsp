<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int attribute = 123; %>
	<%
		int primeiroNumero = 1;
		int segundoNumero = 2;
		int resultado = primeiroNumero + segundoNumero;
		out.println(resultado);
		
		Random geradorNumero = new Random();
		int numeroGerado = geradorNumero.nextInt(11) + 1;
	%>
	<br />
	O número gerado foi <%= numeroGerado %><br />
	O atríbuto é <%= attribute %>
	<%@ include file="segundojsp.jsp" %>
</body>
</html>
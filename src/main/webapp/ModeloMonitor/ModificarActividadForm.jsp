<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">
		<input type="text" name="id_actividad" value="${actividad.id_actividad}">
		<br><br>
		<input type="text" name="nombre" value="${actividad.nombre}">
		<br><br>
		<input type="text" name="precio" value="${actividad.precio}">	
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar grupo</title>
</head>
<body>
<form action="">
		<input type="text" name="id_grupo" placeholder="id_grupo" value="${grupo.id_grupo}">
		<br><br>
		<input type="text" name="dias" placeholder="dias" value="${grupo.dias}">
		<br><br>
		<input type="text" name="horas" placeholder="horas" value="${grupo.horas}">	
		<br><br>
		<input type="text" name="maxPartic" placeholder="maxPartic" value="${grupo.maxPartic}">
		<br><br>
		<input type="text" name="numPartic" placeholder="numPartic" value="${grupo.numPartic}">
	</form>
</body>
</html>
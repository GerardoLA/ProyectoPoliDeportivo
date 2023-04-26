<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserva de pistas</title>
</head>
<body>
<form method="post">
	<input type="text" name="dni" value="${dni}" placeholder="dni">
	<br><br>
	<select name="sala">
		<c:forEach items="${salas}" var="sala">
			<option value="${sala.codigo}">${sala.codigo}</option>
		</c:forEach>
	</select>
	<br><br>
	<select name="horas">
		<option value="11:30">11:30</option>
		<option value="14:15">14:15</option>
		<option value="16:45">16:45</option>
		<option value="20:00">20:00</option>
	</select>
	
	<input type="submit" value="Reservar">
</form>
</body>
</html>
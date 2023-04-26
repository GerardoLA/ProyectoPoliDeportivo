<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserva de pistas</title>
</head>
<body>
<form action="">
	<input type="text" name="dni" placeholder="dni">
	<br><br>
	<select name="rol">
		<c:forEach items="${salas}" var="sala">
			<option value="${sala.codigo}">${sala.codigo}</option>
		</c:forEach>
	</select>
	<br><br>
	<input type="submit" value="Reservar">
</form>
</body>
</html>
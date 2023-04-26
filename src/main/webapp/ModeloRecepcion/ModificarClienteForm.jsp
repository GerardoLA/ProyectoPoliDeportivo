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
	<div class="formulario">
		<form action="" method="POST">
			<input type="text" name="dni" placeholder="dni" value="${cliente.dni}">
			<br><br>
			<input type="text" name="nombre" placeholder="nombre" value="${cliente.nombre}">
			<br><br>
			<input type="text" name="apellido" placeholder="apellido" value="${cliente.apellido}">
			<br><br>
			<input type="text" name="telefono" placeholder="telefono" value="${cliente.telefono}">
			<br><br>
			<input type="email" name="mail" placeholder="mail" value="${cliente.mail}">
			<br><br>
			<input type="date" name="antiguedad" value="${cliente.antiguedad}">	
			<br><br>
			<input type="submit" value="Modificar datos">
		</form>
		<form action="Principal">
				<input type="submit" value="Volver">
		</form>
	</div>
</body>
</html>
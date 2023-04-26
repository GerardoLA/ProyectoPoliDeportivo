<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta cliente</title>
<style>
	body{
		display: flex;
   	 	justify-content: space-evenly;
    	align-items: center;
    	flex-wrap: wrap; 
    		gap: 50px;
	}
</style>
</head>
<body>
	<div class="formulario">
		<form action="" method="POST">
			<input type="text" name="dni" placeholder="dni">
			<br><br>
			<input type="text" name="nombre" placeholder="nombre">
			<br><br>
			<input type="text" name="apellido" placeholder="apellido">
			<br><br>
			<input type="text" name="telefono" placeholder="telefono">
			<br><br>
			<input type="email" name="mail" placeholder="mail">
			<br><br>
			<input type="date" name="antiguedad">	
			<br><br>
			<input type="submit" value="Dar de alta">
		</form>
		<form action="Principal">
				<input type="submit" value="Volver">
		</form>
	</div>
</body>
</html>
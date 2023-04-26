<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
				<h1>Alta Usuario</h1>

	<form method ="post"action="AltaUsuario">
	
		<input type="text" name="id_usuario" placeholder = "id_usuario"/><br>
		<br>
		<input type = "text" name ="nombre" placeholder = "nombre"/><br>
		<br>
		<input type = "text" name ="contrasena" placeholder = "contrasena"/> <br>
		<br>
	
	
	</form>

</body>
</html>
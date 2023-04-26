<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

				<h1>Alta empleado</h1>
	<form method="post" action=" ">
		<input type="text" name="nombre"  placeholder="nombre"/><br>
		<br>
		<input type="text" name="apellido"  placeholder="apellido"/><br>
		<br>
		<input type="text" name="dni"  placeholder="dni"/><br>
		<br>
		<input type="text" name="edad"  placeholder="edad"/><br>
		<br>
		<input type="text" name="Id_jefe"  placeholder="Id_jefe"/><br>
		<br>
		<input type="text" name="Id_usuario"  placeholder="Id_usuario"/><br>
		<br>
		<select name="trabajo">
			<c:forEach items ="${trabajos }" var="trabajo">
				<option value="${trabajo.nombre }">${trabajo.nombre }  </option>
			
			</c:forEach>
		</select>
	
		<input type=submit value="Crear"/>
</form>
</body>
</html>
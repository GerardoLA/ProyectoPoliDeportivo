<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actividades</title>
</head>
<body>
		<table border=1>
			<tr>
				<th scope="row">ID</th>
				<th scope="row">NOMBRE</th>
				<th scope="row">PRECIO</th>
				<th scope="row">MODIFICAR</th>
				<th scope="row">ELIMINAR</th>
			</tr>
			<c:forEach items="${actividades}" var="actividad">
				<tr>
					<td>${actividad.id_actividad}</td>
					<td>${actividad.nombreActividad}</td>
					<td>${actividad.precio}</td>
					<td ><a href="ModificarActividad?id_actividad=${actividad.id_actividad}">Modificar</a></td>		
					<td ><a href="EliminarActividad?id_actividad=${actividad.id_actividad}">Eliminar</a></td>		
				</tr>
			
			</c:forEach>
		
			
		</table>
		
	<form action="VerActividad">
		<input type="text" name="idActividad" placeholder="id">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>
</body>
</html>
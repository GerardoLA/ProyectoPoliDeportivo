<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	
			<tr>
				<td>${actividad.id_actividad}</td>
				<td>${actividad.nombreActividad}</td>
				<td>${actividad.precio}</td>
				<td ><a href="ModificarActividad?id_actividad=${actividad.id_actividad}">Modificar</a></td>		
				<td ><a href="EliminarActividad?id_actividad=${actividad.id_actividad}">Eliminar</a></td>		
			</tr>			
		</table>
</body>
</html>
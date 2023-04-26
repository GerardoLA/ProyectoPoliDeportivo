<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscripcion</title>
</head>
<body>
<table border=1>
	
		<tr>
			<th scope="row">DNI</th>
			<th scope="row">ACTIVIDAD</th>
			<th scope="row">GRUPO</th>
			<th scope="row">FECHA</th>
		</tr>
		<tr>
			<td>${inscripcion.cliente.dni}</td>
			<td>${inscripcion.actividad.nombreActividad}</td>
			<td>${inscripcion.grupo.id_grupo}</td>
			<td>${inscripcion.fecha}</td>
				
			<td ><a href="ModificarInscripcion?dni=${inscripcion.cliente.dni}&actividad=${inscripcion.actividad.nombreActividad}&${inscripcion.grupo.id_grupo}">Modificar</a></td>		
			<td><a href="EliminarInscripcion?dni=${inscripcion.cliente.dni}&actividad=${inscripcion.actividad.nombreActividad}&${inscripcion.grupo.id_grupo}">Eliminar</a></td>	
		</tr>	
	</table>
</body>
</html>
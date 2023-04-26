<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscripciones</title>
</head>
<body>

	<table border=1>
	
		<tr>
			<th scope="row">DNI</th>
			<th scope="row">ACTIVIDAD</th>
			<th scope="row">GRUPO</th>
			<th>HORARIO</th>
			<th scope="row">FECHA</th>
			<th>ELIMINAR</th>
		</tr>
		<tr>
		<c:forEach items="${inscripciones}" var="inscripcion">
			<tr>
				<td>${inscripcion.cliente.dni}</td>
				<td>${inscripcion.actividad.nombreActividad}</td>
				<td>${inscripcion.grupo.id_grupo}</td>
				<td>${inscripcion.grupo.horarios}</td>
				<td>${inscripcion.fecha}</td>
				
				<td><a href="EliminarInscripcion?dni=${inscripcion.cliente.dni}&id_grupo${inscripcion.grupo.id_grupo}">Eliminar</a></td>	
			</tr>
		</c:forEach>
		</tr>
	</table>

	<form action="VerInscripcionCliente">
		<input type="text" name="dniCliente" placeholder="dni">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>
	
	<form action="VerInscripcionActividad">
		<input type="text" name="NombreActividad" placeholder="NombreActividad">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>
</body>
</html>
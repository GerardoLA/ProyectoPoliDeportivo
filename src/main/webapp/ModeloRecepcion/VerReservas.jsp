<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resrevas</title>
</head>
<body>
	<table border=1>
		<tr>
			<th scope="row">DNI</th>
			<th scope="row">SALA</th>
			<th scope="row">FECHA</th>
			<th scope="row">HORA</th>
			<th scope="row">CANCELAR</th>
		</tr>
		<tr>
		<c:forEach items="${reservas}" var="reserva">
				<td>${reserva.cliente.dni}</td>
				<td>${reserva.sala.codigo}</td>
				<td>${reserva.fecha}</td>
				<td>${reserva.hora}</td>
				<td><a href="EliminarReserva?dni=${reserva.cliente.dni}&codigo=${reserva.sala.codigo}">Eliminar</a></td>	
		</c:forEach>
		</tr>
	</table>
	
	<form action="VerReservasCliente">
		<input type="text" name="dniCliente" placeholder="dni">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>
	
	<form action="VerReservasSala">
		<input type="text" name="idSala" placeholder="codigoSala">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>
</body>
</html>
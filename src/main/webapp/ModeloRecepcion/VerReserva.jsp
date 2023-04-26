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
			<th scope="row">DNI</th>
			<th scope="row">SALA</th>
			<th scope="row">FECHA</th>
			<th scope="row">HORA</th>
			<th scope="row">CANCELAR</th>
		</tr>
		<tr>
			<td>${reserva.cliente.dni}</td>
			<td>${reserva.sala.codigo}</td>
			<td>${reserva.fecha}</td>
			<td>${reserva.hora}</td>
			<td><a href="EliminarReserva?dni=${reserva.cliente.dni}&codigo=${reserva.sala.codigo}">Eliminar</a></td>	
		</tr>
	</table>
</body>
</html>